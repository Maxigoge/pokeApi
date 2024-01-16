package org.example.dto.respuestasApi;

import lombok.Data;

import java.util.List;

@Data
public class RespuestaDescripcion {
    private List<FlavorEntries> flavor_text_entries;
}
