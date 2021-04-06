package com.projetofinal.utils.feign;

import com.projetofinal.domains.CEP;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep")
public interface Feign {
    @GetMapping("/{cep}/json")
    CEP buscarEnderecoPor(@PathVariable String cep);
}
