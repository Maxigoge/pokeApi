package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.PokemonDetalladoDto;
import org.example.dto.PokemonInformacionBasicaDto;
import org.example.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping
    public ResponseEntity<List<PokemonInformacionBasicaDto>> getAllPokemons() {
        return new ResponseEntity<>(pokemonService.getAllPokemons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDetalladoDto> getAllPokemons(@PathVariable("id") final Long id) {
        return new ResponseEntity<>(pokemonService.getPokemonById(id), HttpStatus.OK);
    }
}
