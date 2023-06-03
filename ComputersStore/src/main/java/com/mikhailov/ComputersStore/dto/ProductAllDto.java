package com.mikhailov.ComputersStore.dto;

import com.mikhailov.ComputersStore.model.Characteristic;
import com.mikhailov.ComputersStore.model.Manufacturer;
import com.mikhailov.ComputersStore.model.Type;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductAllDto {

    Long id;

    String numberSerial;

    String manufacturer;

    Integer price;

    Integer quantity;

    String type;

    CharacteristicDto characteristic;
}
