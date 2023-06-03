package com.mikhailov.ComputersStore.service;

import com.mikhailov.ComputersStore.dto.ProductAllDto;
import com.mikhailov.ComputersStore.dto.ProductDto;
import com.mikhailov.ComputersStore.exception.UniqueException;
import com.mikhailov.ComputersStore.mapper.ComputerStoreMapper;
import com.mikhailov.ComputersStore.model.*;
import com.mikhailov.ComputersStore.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.mikhailov.ComputersStore.mapper.ComputerStoreMapper.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ComputerStoreServiceImpl implements ComputerStoreService {

    private final CharacteristicRepository characteristicRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;
    private final TypeRepository typeRepository;
    private final UnitRepository unitRepository;

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(ComputerStoreMapper::toProductDtoFromProduct)
                .collect(Collectors.toList());
    }

    @Override
    public ProductAllDto getProductById(Long id) {
        return null;
    }

    @Override
    public ProductAllDto createProduct(ProductAllDto productAllDto) {

        Unit unit = new Unit(
                productAllDto.getCharacteristic().getUnit());
        if (unitRepository.findAll()
                .stream()
                .noneMatch(cr -> cr.getName().equals(unit.getName()))) {
            unitRepository.save(unit);
        }

        Characteristic characteristic = new Characteristic(
                productAllDto.getCharacteristic().getName(),
                productAllDto.getCharacteristic().getValueChar(),
                new Unit(unit.getUnitId(),
                        unit.getName()));
        if (characteristicRepository.findAll()
                .stream()
                .noneMatch(cr -> cr.getName().equals(characteristic.getName()))) {
            Unit unitSave = unitRepository.findByName(unit.getName());
            characteristic.setUnit(unitSave);
            characteristicRepository.save(characteristic);
        }

        Manufacturer manufacturer = new Manufacturer(
                productAllDto.getManufacturer());
        if (manufacturerRepository.findAll()
                .stream()
                .noneMatch(cr -> cr.getName().equals(manufacturer.getName()))) {
            manufacturerRepository.save(manufacturer);
        }

        Type type = new Type(
                productAllDto.getType());
        if (typeRepository.findAll()
                .stream()
                .noneMatch(cr -> cr.getName().equals(type.getName()))) {
            typeRepository.save(type);
        }

        Product product = toProductFromProductAllDto(productAllDto);
        if (productRepository.findAll()
                .stream()
                .noneMatch(cr -> cr.getNumberSerial().equals(product.getNumberSerial()))) {
            product.setManufacturer(manufacturer);
            productRepository.save(product);
        } else {
            throw new UniqueException(
                    String.format("Серийный номер продукта %s - уже существует", product.getNumberSerial()));
        }

        ProductAllDto productAllDtoSave = toProductAllDtoFromProduct(product);
        productAllDtoSave.setCharacteristic(toCharacteristicDtoFromCharacteristic(characteristic));
        productAllDtoSave.setManufacturer(manufacturer.getName());
        productAllDtoSave.setType(type.getName());
        productAllDtoSave.getCharacteristic().setUnit(unit.getName());

        return productAllDtoSave;
    }

    @Override
    public ProductAllDto updateProduct(ProductDto productDto) {
        return null;
    }
}
