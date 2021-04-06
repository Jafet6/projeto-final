package com.projetofinal.repository;

import com.projetofinal.domains.CEP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CEPRepository extends JpaRepository<CEP, Long> {
}
