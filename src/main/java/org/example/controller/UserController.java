package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.PokemonDto;
import org.example.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pokemon")
@RequiredArgsConstructor
public class UserController {

    private final PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<PokemonDto> getAllPokemons() {
        return new ResponseEntity<>(pokemonService.getAllPokemons(), HttpStatus.OK);
    }
}
