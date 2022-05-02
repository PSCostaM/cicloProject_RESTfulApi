package a.com.example.demo.dto;

import lombok.Data;

@Data
public class EstacionamientoResponse {
    private String idEstacionamiento;
    private String ubication;
    private int espacios;
    private boolean flagLleno;
    private int idDireccion;
}
