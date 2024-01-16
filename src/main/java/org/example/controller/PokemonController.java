package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.dto.PokemonDetalladoDto;
import org.example.dto.PokemonInformacionBasicaDto;
import org.example.dto.respuestasApi.RespuestaDescripcion;
import org.example.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "pokemon-controller", description = "Pokemon Rest API")
@RequestMapping("/api/v1/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Lista de pokemones con información básica")
    public ResponseEntity<List<PokemonInformacionBasicaDto>> getAllPokemons() {
        return new ResponseEntity<>(pokemonService.getAllPokemons(), HttpStatus.OK);
    }

    @GetMapping("/{idPokemon}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Pokemon por IdPokemon con información detallada")
    public ResponseEntity<PokemonDetalladoDto> getPokemonById(
            @PathVariable("idPokemon")
            @Parameter(name = "idPokemon", description = "Id del Pokemon", example = "12")
            final Long idPokemon

    ) {
        return new ResponseEntity<>(pokemonService.getPokemonById(idPokemon), HttpStatus.OK);
    }
}
