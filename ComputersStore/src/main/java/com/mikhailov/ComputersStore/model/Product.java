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
public class Product {

    Long id;

    String numberSerial;

    Long manufacturer;

    Integer price;

    Integer quantity;

    Integer typeId;
}
