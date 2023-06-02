package com.mikhailov.ComputersStore.dto;

import com.mikhailov.ComputersStore.model.Characteristic;
import com.mikhailov.ComputersStore.model.Manufacturer;
import com.mikhailov.ComputersStore.model.Type;
import com.mikhailov.ComputersStore.model.Unit;
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

    Manufacturer manufacturer;

    Integer price;

    Integer quantity;

    Type  type;

    Characteristic characteristic;

}
