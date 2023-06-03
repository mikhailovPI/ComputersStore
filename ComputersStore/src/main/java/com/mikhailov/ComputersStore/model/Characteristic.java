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
@Table(name = "characteristics", schema = "public")
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "value_characteristic")
    String valueChar;

    @OneToOne
    @JoinColumn (name = "unit_id")
    Unit unit;

    public Characteristic(String name, String valueChar, Unit unit) {
        this.name = name;
        this.valueChar = valueChar;
        this.unit = unit;
    }
}
