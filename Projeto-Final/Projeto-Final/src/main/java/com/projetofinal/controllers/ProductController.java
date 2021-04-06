package com.projetofinal.controllers;

import com.projetofinal.domains.Product;
import com.projetofinal.repository.ProductRepository;
import com.projetofinal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    private Product create(@Valid @RequestBody Product product) throws Exception {
        return productRepository.save(product);
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
