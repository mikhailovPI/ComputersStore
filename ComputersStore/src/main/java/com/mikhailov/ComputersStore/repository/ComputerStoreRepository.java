package com.mikhailov.ComputersStore.repository;

import com.mikhailov.ComputersStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerStoreRepository extends JpaRepository<Product, Long> {
}
