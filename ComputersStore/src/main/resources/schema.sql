drop table if exists PRODUCTS cascade;

drop table if exists CHARACTERISTICS cascade;

drop table if exists MANUFACTURERS cascade;

drop table if exists TYPES cascade;

drop table if exists UNITS cascade;

CREATE TABLE IF NOT EXISTS types
(
    type_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name    VARCHAR(255)                            NOT NULL,
    PRIMARY KEY (type_id)
);

CREATE TABLE IF NOT EXISTS units
(
    unit_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name    VARCHAR(255)                            NOT NULL,
    PRIMARY KEY (unit_id)

);

CREATE TABLE IF NOT EXISTS characteristics
(
    characteristic_id    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name                 VARCHAR(255)                            NOT NULL,
    value_characteristic VARCHAR(255)                            NOT NULL,
    unit_id              BIGINT,
    PRIMARY KEY (characteristic_id),
    FOREIGN KEY (unit_id) REFERENCES units (unit_id)
);

CREATE TABLE IF NOT EXISTS manufacturers
(
    manufacturer_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name            VARCHAR(255)                            NOT NULL,
    PRIMARY KEY (manufacturer_id)

);

CREATE TABLE IF NOT EXISTS products
(
    product_id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    number_serial     VARCHAR(255)                            NOT NULL,
    manufacturer_id   BIGINT,
    price             BIGINT                                  NOT NULL,
    quantity          BIGINT                                  NOT NULL,
    type_id           BIGINT,
    characteristic_id BIGINT,
    PRIMARY KEY (product_id),
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (manufacturer_id),
    FOREIGN KEY (type_id) REFERENCES types (type_id),
    FOREIGN KEY (characteristic_id) REFERENCES characteristics (characteristic_id)
);