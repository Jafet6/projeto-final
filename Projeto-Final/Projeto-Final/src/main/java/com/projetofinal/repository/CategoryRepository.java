package com.projetofinal.repository;

import com.projetofinal.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
