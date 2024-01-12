package org.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonDto {
    private Integer count;
    private String next;
    private String previous;
    private List<PokemonBaseDto> results;
}
