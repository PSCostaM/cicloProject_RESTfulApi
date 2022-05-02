package a.com.example.demo.dto;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequest {
    @NotBlank
    private Long idUsuario;
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String Email;
    private String imagenUsuario;
    @NotBlank
    private String Contrasenha;
    @NotBlank
    private String metodoEncriptacion;
}
