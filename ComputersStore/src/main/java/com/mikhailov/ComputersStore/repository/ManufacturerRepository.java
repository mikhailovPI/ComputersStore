package com.mikhailov.ComputersStore.repository;

import com.mikhailov.ComputersStore.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findByName(String name);
}

