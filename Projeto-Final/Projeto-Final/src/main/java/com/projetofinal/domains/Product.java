package com.projetofinal.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Max(80)
    private String name;

    private String barCode;

    private String unitMeasure;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Category category;

    private Float price;

    private Float unitPrice;

    private Integer stock;

    public Product(String name, String barCode, String unitMeasure, Brand brand, Category category, Float price, Float unitPrice, Integer stock) {
        this.name = name;
        this.barCode = barCode;
        this.unitMeasure = unitMeasure;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }
}
