package org.example.dto.respuestasApi;

import lombok.Data;

import java.util.List;

@Data
public class RespuestaListaPokemonDto {
    private List<PokemonBaseDto> results;
}
