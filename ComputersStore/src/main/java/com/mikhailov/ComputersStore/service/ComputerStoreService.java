package com.mikhailov.ComputersStore.service;

import com.mikhailov.ComputersStore.dto.ProductAllDto;
import com.mikhailov.ComputersStore.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComputerStoreService {
    List<ProductDto> getProducts();

    ProductAllDto getProductById(Long id);

    List<ProductDto> getProductsByType(String typeName);

    ProductAllDto createProduct(ProductAllDto productAllDto);

    ProductAllDto updateProduct(Long id, ProductAllDto productAllDto);

    void deleteProductById(Long id);

    void deleteProducts();
}
