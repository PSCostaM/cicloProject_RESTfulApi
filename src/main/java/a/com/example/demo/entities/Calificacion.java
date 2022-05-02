package a.com.example.demo.entities;
import lombok.*;

import java.util.Date;

import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Calificacion")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "idCalificacion")
    private String idcalificacion; 
    @Column(name = "fechaCalificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacalificacion;
    @Column(name = "Estrellas")
    private int Estrellas;
    @Column(name = "descripcionCalificacion")
    private String descripcionCalificacion;
    @Column(name = "idUsuario")
    private int idUsuario;
    @Column(name = "idEstacionamiento")
    private int idEstacionamiento;
}
