package a.com.example.demo.dto;
import lombok.Data;

@Data
public class UsuarioResponse {
    private Long idUsuario;
    private String nombreUsuario;
    private String Email;
    private String imagenUsuario;
    private String Contrasenha;
    private String metodoEncriptacion;
}
