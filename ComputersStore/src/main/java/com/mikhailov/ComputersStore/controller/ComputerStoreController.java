package com.mikhailov.ComputersStore.controller;

import com.mikhailov.ComputersStore.dto.ProductAllDto;
import com.mikhailov.ComputersStore.dto.ProductDto;
import com.mikhailov.ComputersStore.model.Product;
import com.mikhailov.ComputersStore.service.ComputerStoreService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/product")
@Slf4j
public class ComputerStoreController {

    private ComputerStoreService computerStoreService;

    @GetMapping(path = "/all")
    public List<ProductDto> getProducts () {
        return computerStoreService.getProducts();
    }

    @GetMapping(path = "/{id}")
    public List<ProductDto> getProductById (@PathVariable Long id) {
        return computerStoreService.getProductById(id);
    }

    @PostMapping(name = "/create")
    public ProductAllDto createProduct (@RequestBody ProductAllDto productAllDto) {
        return computerStoreService.createProduct(productAllDto);
    }

    @PatchMapping(name = "/path")
    public ProductAllDto updateProduct (@RequestBody ProductDto productDto) {
        return computerStoreService.updateProduct(productDto);
    }
}
