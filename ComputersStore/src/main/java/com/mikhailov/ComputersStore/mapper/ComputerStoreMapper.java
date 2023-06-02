package com.mikhailov.ComputersStore.mapper;

import com.mikhailov.ComputersStore.dto.ProductAllDto;
import com.mikhailov.ComputersStore.dto.ProductDto;
import com.mikhailov.ComputersStore.model.Characteristic;
import com.mikhailov.ComputersStore.model.Product;

public class ComputerStoreMapper {

    public static Product toProductFromProductDto (ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getNumberSerial(),
                productDto.getManufacturer(),
                productDto.getPrice(),
                productDto.getQuantity(),
                productDto.getType()
        );
    }

    public static ProductDto toProductDtoFromProduct (Product product) {
        return new ProductDto(
                product.getId(),
                product.getNumberSerial(),
                product.getManufacturer(),
                product.getPrice(),
                product.getQuantity(),
                product.getType(),
                new Characteristic()
        );
    }

    public static ProductAllDto toProductAllDtoFromProduct (Product product) {
        return new ProductAllDto(
                product.getId(),
                product.getNumberSerial(),
                product.getManufacturer(),
                product.getPrice(),
                product.getQuantity(),
                product.getType(),
                new Characteristic()
        );
    }

    public static Product toProductFromProductAllDto (ProductAllDto productAllDto) {
        return new Product(
                productAllDto.getId(),
                productAllDto.getNumberSerial(),
                productAllDto.getManufacturer(),
                productAllDto.getPrice(),
                productAllDto.getQuantity(),
                productAllDto.getType()
        );
    }


}

