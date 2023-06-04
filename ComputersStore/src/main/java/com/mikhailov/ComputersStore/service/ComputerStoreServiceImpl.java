package com.mikhailov.ComputersStore.service;

import com.mikhailov.ComputersStore.dto.ProductAllDto;
import com.mikhailov.ComputersStore.dto.ProductDto;
import com.mikhailov.ComputersStore.exception.NotFoundException;
import com.mikhailov.ComputersStore.mapper.ComputerStoreMapper;
import com.mikhailov.ComputersStore.model.*;
import com.mikhailov.ComputersStore.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.mikhailov.ComputersStore.mapper.ComputerStoreMapper.toProductAllDtoFromProduct;
import static com.mikhailov.ComputersStore.mapper.ComputerStoreMapper.toProductFromProductAllDto;

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
        return toProductAllDtoFromProduct(findProductById(id));
    }

    @Override
    @Transactional
    public ProductAllDto createProduct(ProductAllDto productAllDto) {
        Unit unit = createUnit(productAllDto);
        Characteristic characteristic = createCharacteristic(productAllDto, unit);
        Manufacturer manufacturer = createManufacturer(productAllDto);
        Type type = createType(productAllDto);
        Product product = createProduct(productAllDto, characteristic, manufacturer, type);
        return toProductAllDtoFromProduct(product);
    }

    @Override
    @Transactional
    public ProductAllDto updateProduct(Long id, ProductAllDto productAllDto) {
        Product productUpdate = findProductById(id);

        updateUnit(productAllDto, productUpdate);
        updateCharacteristic(productAllDto, productUpdate);
        updateManufacturer(productAllDto, productUpdate);
        updateType(productAllDto, productUpdate);
        updateProduct(productAllDto, productUpdate);

        return toProductAllDtoFromProduct(productUpdate);
    }

    @Override
    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteProducts() {
        productRepository.deleteAll();
    }

    private Product createProduct(
            ProductAllDto productAllDto,
            Characteristic characteristic,
            Manufacturer manufacturer,
            Type type) {
        Product product = toProductFromProductAllDto(productAllDto);
        if (productRepository.findAll()
                .stream()
                .noneMatch(cr -> cr.getNumberSerial().equals(product.getNumberSerial()))) {
            Manufacturer manufacturerSave = manufacturerRepository.findByName(manufacturer.getName());
            Type typeSave = typeRepository.findByName(type.getName());
            Characteristic characteristicSave = characteristicRepository.findByName(characteristic.getName());
            product.setManufacturer(manufacturerSave);
            product.setType(typeSave);
            product.setCharacteristic(characteristicSave);
            productRepository.save(product);
        }
        return product;
    }

    private Type createType(ProductAllDto productAllDto) {
        Type type = new Type(
                productAllDto.getType());
        if (typeRepository.findAll()
                .stream()
                .noneMatch(cr -> cr.getName().equals(type.getName()))) {
            typeRepository.save(type);
        }
        return type;
    }

    private Manufacturer createManufacturer(ProductAllDto productAllDto) {
        Manufacturer manufacturer = new Manufacturer(
                productAllDto.getManufacturer());
        if (manufacturerRepository.findAll()
                .stream()
                .noneMatch(cr -> cr.getName().equals(manufacturer.getName()))) {
            manufacturerRepository.save(manufacturer);
        }
        return manufacturer;
    }

    private Characteristic createCharacteristic(ProductAllDto productAllDto, Unit unit) {
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
        return characteristic;
    }

    private Unit createUnit(ProductAllDto productAllDto) {
        Unit unit = new Unit(
                productAllDto.getCharacteristic().getUnit());
        if (unitRepository.findAll()
                .stream()
                .noneMatch(cr -> cr.getName().equals(unit.getName()))) {
            unitRepository.save(unit);
        }
        return unit;
    }

    private void updateProduct(ProductAllDto productAllDto, Product productUpdate) {
        if (!productUpdate.getNumberSerial().equals(productAllDto.getNumberSerial())) {
            productUpdate.setNumberSerial(productAllDto.getNumberSerial());
            productRepository.save(productUpdate);
        }
        if (!productUpdate.getPrice().equals(productAllDto.getPrice())) {
            productUpdate.setPrice(productAllDto.getPrice());
            productRepository.save(productUpdate);
        }
        if (!productUpdate.getQuantity().equals(productAllDto.getQuantity())) {
            productUpdate.setQuantity(productAllDto.getQuantity());
            productRepository.save(productUpdate);
        }
    }

    private void updateType(ProductAllDto productAllDto, Product productUpdate) {
        Long typeId = productUpdate.getType().getTypeId();
        Type type = findTypeById(typeId);
        if (!type.getName().equals(productAllDto.getType())) {
            type.setName(productAllDto.getType());
            typeRepository.save(type);
        }
    }

    private void updateManufacturer(ProductAllDto productAllDto, Product productUpdate) {
        Long manId = productUpdate.getManufacturer().getManufacturerId();
        Manufacturer manufacturer = findManufacturerById(manId);
        if (!manufacturer.getName().equals(productAllDto.getManufacturer())) {
            manufacturer.setName(productAllDto.getManufacturer());
            manufacturerRepository.save(manufacturer);
        }
    }

    private void updateCharacteristic(ProductAllDto productAllDto, Product productUpdate) {
        Long charId = productUpdate.getCharacteristic().getId();
        Characteristic characteristic = findCharacteristicById(charId);
        if (!characteristic.getName().equals(productAllDto.getCharacteristic().getName())) {
            characteristic.setName(productAllDto.getCharacteristic().getName());
            characteristicRepository.save(characteristic);
        }
        if (!characteristic.getValueChar().equals(productAllDto.getCharacteristic().getValueChar())) {
            characteristic.setValueChar(productAllDto.getCharacteristic().getValueChar());
            characteristicRepository.save(characteristic);
        }
    }

    private void updateUnit(ProductAllDto productAllDto, Product productUpdate) {
        Long unitId = productUpdate.getCharacteristic().getUnit().getUnitId();
        Unit unit = findUnitById(unitId);
        if (!unit.getName().equals(productAllDto.getCharacteristic().getUnit())) {
            unit.setName(productAllDto.getCharacteristic().getUnit());
            unitRepository.save(unit);
        }
    }

    private Type findTypeById(Long typeId) {
        return typeRepository.findById(typeId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Производителя %s не существует.", typeId)));
    }

    private Manufacturer findManufacturerById(Long manId) {
        return manufacturerRepository.findById(manId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Производителя %s не существует.", manId)));
    }

    private Characteristic findCharacteristicById(Long charId) {
        return characteristicRepository.findById(charId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Характеристики продукта %s не существует.", charId)));
    }

    private Unit findUnitById(Long unitId) {
        return unitRepository.findById(unitId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Единица измерения %s не существует.", unitId)));
    }

    private Product findProductById(Long prodId) {
        return productRepository.findById(prodId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Продукт с идентификационным номером %s не существует.", prodId)));
    }
}
