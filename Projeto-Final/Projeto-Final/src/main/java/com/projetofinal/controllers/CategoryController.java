package com.projetofinal.controllers;

import com.projetofinal.domains.Category;
import com.projetofinal.repository.CategoryRepository;
import com.projetofinal.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    private Category create(@Valid @RequestBody Category category) throws Exception {
        return categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        categoryRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") Long id) {
        return categoryRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    private Category updateById(@PathVariable("id") Long id, @Valid @RequestBody Category category) throws Exception {
        category.setId(id);
        return categoryRepository.save(category);
    }

    @GetMapping
    private List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
