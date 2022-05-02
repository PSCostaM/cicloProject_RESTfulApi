package a.com.example.demo.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CalificacionResponse {
    private String idcalificacion;
    private Date fechacalificacion;
    private int Estrellas;
    private String descripcionCalificacion;
    private int idUsuario;
    private int idEstacionamiento;
}
