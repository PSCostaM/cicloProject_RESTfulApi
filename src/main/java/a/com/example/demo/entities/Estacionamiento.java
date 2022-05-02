package a.com.example.demo.entities;
import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Estacionamiento")
public class Estacionamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_Estacionamiento")
    private String idEstacionamiento;
    @Column(name = "UbicacionEstacionamiento")
    private String ubication;
    @Column(name = "Espacios")
    private int espacios;
    @Column(name = "flagLleno")
    private boolean flagLleno;
    @Column(name = "idDireccion")
    private int idDireccion;
}
