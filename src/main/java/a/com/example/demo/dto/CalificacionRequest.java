package a.com.example.demo.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

import java.util.Date;

@Data
public class CalificacionRequest {
    @NotBlank
    private String idcalificacion;
    @NotBlank
    private Date fechacalificacion;
    @NotBlank
    private int Estrellas;
    private String descripcionCalificacion;
    @NotBlank
    private int idUsuario;
    @NotBlank
    private int idEstacionamiento;
}
