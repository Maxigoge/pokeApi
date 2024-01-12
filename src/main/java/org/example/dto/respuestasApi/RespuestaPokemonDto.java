package org.example.dto.respuestasApi;

import lombok.Data;

import java.util.List;

@Data
public class RespuestaPokemonDto {
    private Sprites sprites;
    private List<Type> types;
    private String weight;
    private List<Ability> abilities;

    //detallado
    private String description;
    private List<Moves> moves;
}
