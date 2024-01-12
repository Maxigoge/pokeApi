package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PokemonDetalladoDto {
    private PokemonInformacionBasicaDto informacionBasica;
    private String descripcion;
    private List<String> listadoDeMovimientos;
}
