package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PokemonInformacionBasicaDto {
    private String foto;
    private List<String> tipo;
    private String peso;
    private List<String> listadoDeHabilidades;
}
