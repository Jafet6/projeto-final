package com.projetofinal.controllers;

import com.projetofinal.domains.Brand;
import com.projetofinal.repository.BrandRepository;
import com.projetofinal.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    @PostMapping
    private Brand create(@Valid @RequestBody Brand brand) throws Exception {
        return brandRepository.save(brand);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        brandRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Brand findById(@PathVariable("id") Long id) {
        return brandRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    private Brand updateById(@PathVariable("id") Long id, @Valid @RequestBody Brand brand) throws Exception {
        brand.setId(id);
        return brandRepository.save(brand);
    }

    @GetMapping
    private List<Brand> findAll() {
        return brandRepository.findAll();
    }
}
