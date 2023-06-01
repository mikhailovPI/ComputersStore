package com.mikhailov.ComputersStore.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductsCharacteristics {

    Long productId;

    Integer characteristicId;

    Integer unitId;

    String valueCharacteristic;
}
