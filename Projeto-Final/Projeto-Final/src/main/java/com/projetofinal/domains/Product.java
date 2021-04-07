package com.projetofinal.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    @Size( max = 30)
    @Column(length = 30, nullable = false)
    private String name;

    private String barCode;

    private String unitMeasure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private BigDecimal unitPrice;

    private BigDecimal stock;

    public Product(String name, String barCode, String unitMeasure, Brand brand, Category category, BigDecimal unitPrice, BigDecimal stock) {
        this.name = name;
        this.barCode = barCode;
        this.unitMeasure = unitMeasure;
        this.brand = brand;
        this.category = category;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }
}
