package com.mikhailov.ComputersStore.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "products", schema = "public")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    Long id;

    @Column(name = "number_serial")
    String numberSerial;

    @OneToOne
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;

    @Column(name = "price")
    Integer price;

    @Column(name = "quantity")
    Integer quantity;

//    @OneToOne
//    @JoinColumn(name = "type_id")
//    Type type;
}