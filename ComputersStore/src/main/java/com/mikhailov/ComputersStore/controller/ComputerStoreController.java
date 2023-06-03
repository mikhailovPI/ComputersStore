package com.mikhailov.ComputersStore.controller;

import com.mikhailov.ComputersStore.dto.ProductAllDto;
import com.mikhailov.ComputersStore.dto.ProductDto;
import com.mikhailov.ComputersStore.service.ComputerStoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/product")
@Slf4j
public class ComputerStoreController {

    private final ComputerStoreService computerStoreService;

    @GetMapping(path = "/all")
    public List<ProductDto> getProducts () {
        return computerStoreService.getProducts();
    }

    @GetMapping(path = "/{id}")
    public ProductAllDto getProductById (@PathVariable Long id) {
        return computerStoreService.getProductById(id);
    }

    @PostMapping(path = "/create")
    public ProductAllDto createProduct (@RequestBody ProductAllDto productAllDto) {
        log.info("PostMapping/Создание продукта: " + productAllDto);
        return computerStoreService.createProduct(productAllDto);
    }

    @PatchMapping(path = "/path")
    public ProductAllDto updateProduct (@RequestBody ProductDto productDto) {
        return computerStoreService.updateProduct(productDto);
    }
}
