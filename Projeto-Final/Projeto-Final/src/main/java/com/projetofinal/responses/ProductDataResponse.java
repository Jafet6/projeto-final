package com.projetofinal.responses;

import com.projetofinal.domains.Brand;
import com.projetofinal.domains.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDataResponse {
    private String name;
    private String barCode;
    private String unitMeasure;
    private Brand brand;
    private Category category;
    private Float price;
    private Float unitPrice;
    private Integer stock;
}
