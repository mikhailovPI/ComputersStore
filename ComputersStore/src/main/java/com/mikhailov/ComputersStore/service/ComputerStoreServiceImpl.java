package com.mikhailov.ComputersStore.service;

import com.mikhailov.ComputersStore.dto.ProductAllDto;
import com.mikhailov.ComputersStore.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ComputerStoreServiceImpl implements ComputerStoreService {
    @Override
    public List<ProductDto> getProducts() {
        return null;
    }

    @Override
    public List<ProductDto> getProductById(Long id) {
        return null;
    }

    @Override
    public ProductAllDto createProduct(ProductAllDto productAllDto) {
        return null;
    }

    @Override
    public ProductAllDto updateProduct(ProductDto productDto) {
        return null;
    }
}
