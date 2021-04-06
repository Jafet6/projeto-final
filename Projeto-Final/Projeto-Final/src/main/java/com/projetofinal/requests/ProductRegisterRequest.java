package com.projetofinal.requests;

import com.projetofinal.domains.Brand;
import com.projetofinal.domains.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegisterRequest {
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 80)
    private String name;
    private String barCode;
    private String unitMeasure;
    private Brand brand;
    private Category category;
    private Float price;
    private Float unitPrice;
    private Integer stock;
}
