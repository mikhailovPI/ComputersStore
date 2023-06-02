package com.mikhailov.ComputersStore.repository;

import com.mikhailov.ComputersStore.model.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {
}
