package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.PokemonDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PokemonService {

    @Value("${sping.external.service.base-url}")
    private String basePath;

    private final RestTemplate restTemplate;

    public PokemonDto getAllPokemons() {
        PokemonDto paginaPokemons = restTemplate.getForObject(basePath + "/pokemon", PokemonDto.class);
        return paginaPokemons;
    }
}
