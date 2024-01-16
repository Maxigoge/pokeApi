package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.PokemonDetalladoDto;
import org.example.dto.PokemonInformacionBasicaDto;
import org.example.dto.respuestasApi.Ability;
import org.example.dto.respuestasApi.Moves;
import org.example.dto.respuestasApi.PokemonBaseDto;
import org.example.dto.respuestasApi.RespuestaListaPokemonDto;
import org.example.dto.respuestasApi.RespuestaPokemonDto;
import org.example.dto.respuestasApi.Type;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonService {

    @Value("${sping.external.service.base-url}")
    private String basePath;

    private final RestTemplate restTemplate;

    public List<PokemonInformacionBasicaDto> getAllPokemons() {
        RespuestaListaPokemonDto respuestaListaPokemonDto =
                restTemplate.getForObject(basePath + "/pokemon", RespuestaListaPokemonDto.class);

        assert respuestaListaPokemonDto != null;
        List<PokemonBaseDto> lista = respuestaListaPokemonDto.getResults();
        List<PokemonInformacionBasicaDto> listaPokemons = new ArrayList<>();
        for (PokemonBaseDto pokemonBase : lista) {
            String nombrePokemon = pokemonBase.getName();
            RespuestaPokemonDto respuesta =
                    restTemplate.getForObject(basePath + "/pokemon/" + nombrePokemon, RespuestaPokemonDto.class);

            List<String> tipos = new ArrayList<>();
            assert respuesta != null;
            List<String> habilidades = getTypes(respuesta, tipos);

            PokemonInformacionBasicaDto pokemonInformacionBasicaDto = PokemonInformacionBasicaDto.builder()
                    .foto(respuesta.getSprites().getFront_default())
                    .tipo(tipos)
                    .peso(respuesta.getWeight())
                    .listadoDeHabilidades(habilidades)
                    .build();

            listaPokemons.add(pokemonInformacionBasicaDto);
        }

        return listaPokemons;
    }

    public PokemonDetalladoDto getPokemonById(final Long idPokemon) {
        RespuestaPokemonDto respuesta =
                restTemplate.getForObject(basePath + "/pokemon/" + idPokemon, RespuestaPokemonDto.class);

        List<String> tipos = new ArrayList<>();
        assert respuesta != null;

        List<String> habilidades = getTypes(respuesta, tipos);
        List<String> movimientos = new ArrayList<>();
        for (Moves moves : respuesta.getMoves()){
            movimientos.add(moves.getMove().getName());
        }

        PokemonInformacionBasicaDto pokemonInformacionBasicaDto = PokemonInformacionBasicaDto.builder()
                .foto(respuesta.getSprites().getFront_default())
                .tipo(tipos)
                .peso(respuesta.getWeight())
                .listadoDeHabilidades(habilidades)
                .build();

        return PokemonDetalladoDto.builder()
                .informacionBasica(pokemonInformacionBasicaDto)
                .listadoDeMovimientos(movimientos)
                .build();
    }

    private List<String> getTypes(final RespuestaPokemonDto respuesta, final List<String> tipos) {
        for (Type tipoO : respuesta.getTypes()){
            tipos.add(tipoO.getType().getName());
        }
        List<String> habilidades = new ArrayList<>();
        for (Ability ability : respuesta.getAbilities()){
            habilidades.add(ability.getAbility().getName());
        }
        return habilidades;
    }
}
