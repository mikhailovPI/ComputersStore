package com.mikhailov.ComputersStore.mapper;

import com.mikhailov.ComputersStore.dto.CharacteristicDto;
import com.mikhailov.ComputersStore.dto.ProductAllDto;
import com.mikhailov.ComputersStore.dto.ProductDto;
import com.mikhailov.ComputersStore.model.*;

public class ComputerStoreMapper {

    public static ProductDto toProductDtoFromProduct (Product product) {
        return new ProductDto(
                product.getId(),
                product.getNumberSerial(),
                product.getManufacturer().getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getType().getName(),
                new CharacteristicDto(
                        product.getCharacteristic().getName(),
                        product.getCharacteristic().getValueChar(),
                        product.getCharacteristic().getUnit().getName())
        );
    }

    public static ProductAllDto toProductAllDtoFromProduct (Product product) {
        return new ProductAllDto(
                product.getId(),
                product.getNumberSerial(),
                product.getManufacturer().getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getType().getName(),
                new CharacteristicDto(
                        product.getCharacteristic().getName(),
                        product.getCharacteristic().getValueChar(),
                        product.getCharacteristic().getUnit().getName())
        );
    }

    public static Product toProductFromProductAllDto (ProductAllDto productAllDto) {
        return new Product(
                productAllDto.getId(),
                productAllDto.getNumberSerial(),
                new Manufacturer(productAllDto.getManufacturer()),
                productAllDto.getPrice(),
                productAllDto.getQuantity(),
                new Type(productAllDto.getType()),
                new Characteristic(
                        productAllDto.getCharacteristic().getName(),
                        productAllDto.getCharacteristic().getValueChar(),
                        new Unit(productAllDto.getCharacteristic().getUnit()))
        );
    }
}

