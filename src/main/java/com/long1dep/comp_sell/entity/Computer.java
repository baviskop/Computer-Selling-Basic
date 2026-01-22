package com.long1dep.comp_sell.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "computers")
@Data
@NoArgsConstructor
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computer_id")
    private Long id;

    @Column(name = "computer_model", nullable = false, length = 100)
    @NotBlank(message = "The model is required!")
    @Size(min = 5, max = 100, message = "The model is 5 between 100")
    private String model;

    @Column(name = "type",  nullable = false, length = 100)
    @NotBlank(message = "The type is required")
    private String type;

    @Column(name = "production_year", nullable = false)
    @Min(value = 1990, message = "Product Year is between 1990 ... 2025")
    @Max(value = 2025, message = "Product Year is between 1990 ... 2025")
    private int year;
    @Column(nullable = false)
    @Min(value = 100, message = "Minimum price must be 100")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Computer(String model, String type, int year, Double price, Manufacturer manufacturer) {
        this.model = model;
        this.type = type;
        this.year = year;
        this.price = price;
        this.manufacturer = manufacturer;
    }
}

