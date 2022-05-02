package a.com.example.demo.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EstacionamientoRequest {
    @NotBlank
    private String idEstacionamiento;
    @NotBlank
    private String ubication;
    @NotBlank
    private int espacios;
    private boolean flagLleno;
    private int idDireccion;
}
