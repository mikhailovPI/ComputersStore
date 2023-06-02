package com.mikhailov.ComputersStore.service;

import com.mikhailov.ComputersStore.dto.ProductAllDto;
import com.mikhailov.ComputersStore.dto.ProductDto;
import com.mikhailov.ComputersStore.model.*;
import com.mikhailov.ComputersStore.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return null;
    }

    @Override
    public List<ProductAllDto> getProductById(Long id) {
        return null;
    }

    @Override
    public ProductAllDto createProduct(ProductAllDto productAllDto) {

        Product product = toProductFromProductAllDto(productAllDto);
        productRepository.save(product);
        Characteristic characteristic = characteristicRepository.save(productAllDto.getCharacteristic());
        Manufacturer manufacturer = manufacturerRepository.save(productAllDto.getManufacturer());
        Type type = typeRepository.save(productAllDto.getType());
        Unit unit = unitRepository.save(productAllDto.getCharacteristic().getUnit());

        ProductAllDto productAllDtoSave = toProductAllDtoFromProduct(product);
        productAllDtoSave.setCharacteristic(characteristic);
        productAllDtoSave.setManufacturer(manufacturer);
        productAllDtoSave.setType(type);
        productAllDtoSave.getCharacteristic().setUnit(unit);

        return productAllDtoSave;
    }

    @Override
    public ProductAllDto updateProduct(ProductDto productDto) {
        return null;
    }
}
