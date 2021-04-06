package com.projetofinal.services;

import com.projetofinal.domains.Product;
import com.projetofinal.mappers.ProductMapper;
import com.projetofinal.repository.ProductRepository;
import com.projetofinal.responses.ProductDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;
    private final BrandService brandService;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, CategoryService categoryService, BrandService brandService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
        this.brandService = brandService;
    }

    public ProductDataResponse create(Product product) throws Exception {
//        Category categoria = categoryService.findByName();
//        brandService.save
        productRepository.save(product);
        ProductDataResponse productResponse = productMapper.convertProductDomainToProductResponse(product);
        return productResponse;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        Product product = productRepository.findById(id).get();
        return product;
    }

    private Product updateById(Long id, Product product) throws Exception {
        product.setId(id);
        productRepository.save(product);
        return product;
    }

    private List<Product> findAll() {

        return productRepository.findAll();
    }
}
