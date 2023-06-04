package com.mikhailov.ComputersStore.repository;

import com.mikhailov.ComputersStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTypeName(String typeName);
}
