package com.projetofinal.controllers;

import com.projetofinal.domains.Product;
import com.projetofinal.mappers.ProductMapper;
import com.projetofinal.repository.ProductRepository;
import com.projetofinal.requests.ProductRegisterRequest;
import com.projetofinal.responses.ProductDataResponse;
import com.projetofinal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    private ResponseEntity<Object> create(@Valid @RequestBody ProductRegisterRequest productRequest) throws Exception {
        Product productDomain = productMapper.convertProductRegisterRequestToEntity(productRequest);
//        System.out.println(productDomain.getCategory());
        ProductDataResponse serviceResponse = productService.create(productDomain);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    private Product updateById(@PathVariable("id") Long id, @Valid @RequestBody Product product) throws Exception {
        product.setId(id);
        return productRepository.save(product);
    }

    @GetMapping
    private List<Product> findAll() {
        return productRepository.findAll();
    }
}
