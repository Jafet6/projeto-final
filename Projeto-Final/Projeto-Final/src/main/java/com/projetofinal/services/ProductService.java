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

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
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

//    public void checkIsPresent(dbSearch, errorMessage) {
//        if (!dbSearch.isPresent()) throw new EntityNotFoundException("Categoria nao encontrada");
//    }

    public Category findAndCheckCategory(Product product) {
        Optional<Category> categoryDB = categoryRepository.findByCategory(product.getCategory().getCategory());
        if (!categoryDB.isPresent()) throw new EntityNotFoundException("Categoria nao encontrada");
        return categoryDB.get();
    }

    public Brand findAndCheckBrand(Product product) {
        Optional<Brand> brandDB = brandRepository.findByBrand(product.getBrand().getBrand());
        if (!brandDB.isPresent()) throw new EntityNotFoundException("Marca nao encontrada");
        return brandDB.get();
    }

    public ProductDataResponse create(Product product) throws Exception {
        product.setCategory(findAndCheckCategory(product));

        product.setBrand(findAndCheckBrand(product));
        System.out.println(product.getStock().getClass().getName());
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
        product.setCategory(findAndCheckCategory(product));
        product.setBrand(findAndCheckBrand(product));
        productRepository.save(product);
        ProductDataResponse response = productMapper.convertProductDomainToProductResponse(product);
        return response;
    }

    public List<ProductDataResponse> findAll() {
        List<Product> products = productRepository.findAll();

        List<ProductDataResponse> response = products.stream().map(
                product -> productMapper.convertProductDomainToProductResponse(product))
                .collect(Collectors.toList());

        return response;
    }

    public List<ProductDataResponse> findAllByCategoryId(Long id) {
        List<Product> products = productRepository.findAllByCategoryId(id);

        List<ProductDataResponse> response = products.stream().map(
                product -> productMapper.convertProductDomainToProductResponse(product))
                .collect(Collectors.toList());

        return response;
    }

//    public List<Object> convertToListOfObject(List<Object> list, Method converter) {
//        List<Object> response = list.stream().map(
//                element -> converter(element))
//                .collect(Collectors.toList());
//    }

    public List<ProductDataResponse> findAllByBrandId(Long id) {
        List<Product> products = productRepository.findAllByBrandId(id);

        List<ProductDataResponse> response = products.stream().map(
                product -> productMapper.convertProductDomainToProductResponse(product))
                .collect(Collectors.toList());

        return response;
    }
}
