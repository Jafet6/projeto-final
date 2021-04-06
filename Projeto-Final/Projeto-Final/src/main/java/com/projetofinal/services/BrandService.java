package com.projetofinal.services;

import com.projetofinal.domains.Brand;
import com.projetofinal.repository.BrandRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrandService {
    private BrandRepository brandRepository;


    public Brand create(Brand brand) throws Exception {
        brandRepository.save(brand);
        return brand;
    }

    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }

    public Brand findById(Long id) {
        Brand brand = brandRepository.findById(id).get();
        return brand;
    }

    private Brand updateById(Long id, Brand brand) throws Exception {
        brand.setId(id);
        brandRepository.save(brand);
        return brand;
    }

    private List<Brand> findAll() {

        return brandRepository.findAll();
    }
}
