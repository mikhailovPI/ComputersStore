package com.mikhailov.ComputersStore.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

    Long id;

    String numberSerial;

    String manufacturer;

    Double price;

    Integer quantity;

    String type;

    CharacteristicDto characteristic;
}
