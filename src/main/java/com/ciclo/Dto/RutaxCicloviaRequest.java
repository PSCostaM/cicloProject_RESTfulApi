package com.ciclo.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RutaxCicloviaRequest {
    @NotBlank
    private int tiempoRealizado;
    @NotBlank
    private long idRuta;
    @NotBlank
    private long idCiclovia;
}
