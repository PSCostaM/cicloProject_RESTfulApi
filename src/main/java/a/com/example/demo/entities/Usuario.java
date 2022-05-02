package a.com.example.demo.entities;
import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuario")
public class Usuario {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "idUsuario")
    private Long idUsuario;
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Column(name = "Email")
    private String Email;
    @Column(name = "imagenUsuario")
    private String imagenUsuario;
    @Column(name = "Contrasenha")
    private String Contrasenha;
    @Column(name = "metodoEncriptacion")
    private String metodoEncriptacion;
}
