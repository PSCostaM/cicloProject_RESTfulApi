package com.ciclo.Dto;

import lombok.Data;

@Data
public class RutaResponse {
    private long idRuta;
    private String ubicacionSalida;
    private String ubicacionLlegada;
    private boolean flagTerminado;
    private long idUser;
}
