package com.projetofinal.utils.rest;

import com.projetofinal.domains.CEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RestTemplateFactory {
    private final RestTemplate restTemplate = new RestTemplate();

    public CEP getCep(String cep) {
        String URL_VIA_CEP = "https://viacep.com.br/ws/" + cep + "/json";
        return restTemplate.getForObject(URL_VIA_CEP, CEP.class);
    }
}
