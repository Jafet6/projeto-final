package com.projetofinal.responses;

import com.projetofinal.domains.Brand;
import com.projetofinal.domains.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDataResponse {
    private String name;
    private BrandResponse brand;
    private CategoryResponse category;
}
