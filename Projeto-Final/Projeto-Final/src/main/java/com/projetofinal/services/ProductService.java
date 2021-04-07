package com.projetofinal.services;

import com.projetofinal.domains.Brand;
import com.projetofinal.domains.Category;
import com.projetofinal.domains.Product;
import com.projetofinal.mappers.ProductMapper;
import com.projetofinal.repository.BrandRepository;
import com.projetofinal.repository.CategoryRepository;
import com.projetofinal.repository.ProductRepository;
import com.projetofinal.responses.MessageResponse;
import com.projetofinal.responses.ProductDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper, CategoryService categoryService, BrandService brandService, CategoryRepository categoryRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    public ProductDataResponse create(Product product) throws Exception {
        Category category = categoryRepository.findByCategory(product.getCategory().getCategory()).get();
        product.setCategory(category);

        Brand brand = brandRepository.findByBrand(product.getBrand().getBrand()).get();
        product.setBrand(brand);

        productRepository.save(product);

        ProductDataResponse productResponse = productMapper.convertProductDomainToProductResponse(product);
        return productResponse;
    }

    public MessageResponse deleteById(Long id) {
        productRepository.deleteById(id);
        MessageResponse response = new MessageResponse("Produto deletado com sucesso");
        return response;
    }

    public ProductDataResponse findById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductDataResponse response = productMapper.convertProductDomainToProductResponse(product);
        return response;
    }

    public ProductDataResponse updateById(Long id, Product product) throws Exception {
        product.setId(id);
        productRepository.save(product);
        ProductDataResponse response = productMapper.convertProductDomainToProductResponse(product);
        return response;
    }

    public List<ProductDataResponse> findAll() {
        List<Product> products = productRepository.findAll();
        System.out.println(products);

        List<ProductDataResponse> response = products.stream().map(
                product -> productMapper.convertProductDomainToProductResponse(product))
                .collect(Collectors.toList());

        return response;
    }
}
