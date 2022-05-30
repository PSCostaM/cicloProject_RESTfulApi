package com.ciclo.Dto;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RutaRequest {
    @NotBlank
    private String ubicacionSalida;
    @NotBlank
    private String ubicacionLlegada;
    @NotBlank
    private long idUser;
}
