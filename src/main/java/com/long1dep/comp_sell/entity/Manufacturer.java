package com.long1dep.comp_sell.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "manufacturers")
@Data
@NoArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private Long id;
    @Column(name = "manufacturer_name", nullable = false, length = 255, columnDefinition = "NVARCHAR(255)", unique = true)
    private String name;
    @Column(name="country", nullable = false, length = 255)
    private String country;

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
