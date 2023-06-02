package com.mikhailov.ComputersStore.repository;

import com.mikhailov.ComputersStore.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
