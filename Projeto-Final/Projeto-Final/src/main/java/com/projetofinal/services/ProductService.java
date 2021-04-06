package com.projetofinal.services;

import com.projetofinal.domains.Category;
import com.projetofinal.domains.Product;
import com.projetofinal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) throws Exception {
        productRepository.save(product);
        return product;
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
