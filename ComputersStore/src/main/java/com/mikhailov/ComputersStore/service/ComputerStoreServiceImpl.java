package com.mikhailov.ComputersStore.service;

import com.mikhailov.ComputersStore.dto.ProductAllDto;
import com.mikhailov.ComputersStore.dto.ProductDto;
import com.mikhailov.ComputersStore.mapper.ComputerStoreMapper;
import com.mikhailov.ComputersStore.model.Product;
import com.mikhailov.ComputersStore.repository.ComputerStoreRepository;
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

    private final ComputerStoreRepository computerStoreRepository;

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
        Product productSave = computerStoreRepository.save(product);
        return toProductAllDtoFromProduct(productSave);
    }

    @Override
    public ProductAllDto updateProduct(ProductDto productDto) {
        return null;
    }
}
