package com.projetofinal.controllers;

import com.projetofinal.domains.CEP;
import com.projetofinal.domains.Product;
import com.projetofinal.mappers.ProductMapper;
import com.projetofinal.repository.ProductRepository;
import com.projetofinal.requests.ProductRegisterRequest;
import com.projetofinal.responses.MessageResponse;
import com.projetofinal.responses.ProductDataResponse;
import com.projetofinal.services.ProductService;
import com.projetofinal.utils.rest.RestTemplateFactory;
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
        ProductDataResponse serviceResponse = productService.create(productDomain);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        MessageResponse message = productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        ProductDataResponse serviceResponse = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);

    }

    @PutMapping("/{id}")
    public Product updateById(@PathVariable("id") Long id, @Valid @RequestBody ProductRegisterRequest productRequest) throws Exception {
        Product product = productMapper.convertProductRegisterRequestToEntity(productRequest);
        ProductDataResponse serviceResponse = productService.updateById(id, product);
        return productRepository.save(product);
    }

    @GetMapping
    private ResponseEntity<List<ProductDataResponse>> findAll() {
        List<ProductDataResponse> serviceResponse = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
    }
}
