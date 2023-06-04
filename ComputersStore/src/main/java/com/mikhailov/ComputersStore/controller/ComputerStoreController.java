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

    @GetMapping(path = "/get/all")
    public List<ProductDto> getProducts () {
        log.info("GetMapping/Получение всех продуктов");
        return computerStoreService.getProducts();
    }

    @GetMapping(path = "/get/{id}")
    public ProductAllDto getProductById (@PathVariable Long id) {
        log.info("GetMapping/Получение продукта: " + id);
        return computerStoreService.getProductById(id);
    }

    @GetMapping(path = "/get/type")
    public List<ProductDto> getProductsByType (@RequestParam String typeName) {
        log.info("GetMapping/Получение продуктов по типу: " + typeName);
        return computerStoreService.getProductsByType(typeName);
    }

    @PostMapping(path = "/create")
    public ProductAllDto createProduct (@RequestBody ProductAllDto productAllDto) {
        log.info("PostMapping/Создание продукта: " + productAllDto);
        return computerStoreService.createProduct(productAllDto);
    }

    @PatchMapping(path = "/update/{id}")
    public ProductAllDto updateProduct (
            @PathVariable Long id,
            @RequestBody ProductAllDto productAllDto) {
        log.info("PatchMapping/Обновление продукта: " + id);
        return computerStoreService.updateProduct(id, productAllDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteProductById (@PathVariable Long id) {
        log.info("DeleteMapping/Удаление продукта: " + id);
        computerStoreService.deleteProductById(id);
    }

    @DeleteMapping(path = "/delete")
    public void deleteProducts() {
        log.info("DeleteMapping/Удаление всех продуктов");
        computerStoreService.deleteProducts();
    }
}

