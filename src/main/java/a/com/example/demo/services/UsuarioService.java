package a.com.example.demo.services;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.List;

import a.com.example.demo.dto.UsuarioRequest;
import a.com.example.demo.entities.Usuario;
import a.com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository repository) { this.usuarioRepository = repository; }

    @Transactional
    public Usuario createUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuarioNew = initUsuario(usuarioRequest);
        return usuarioRepository.save(usuarioNew);
    }

    @Transactional(readOnly = true)
    public List<Usuario> getAllRutas() {
        return usuarioRepository.getListaRutasxUsuario();
    }

    private Usuario initUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuarioObj = new Usuario();
        usuarioObj.setIdUsuario(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        usuarioObj.setNombreUsuario(usuarioRequest.getNombreUsuario());
        usuarioObj.setEmail(usuarioRequest.getEmail());
        usuarioObj.setImagenUsuario(usuarioRequest.getImagenUsuario());
        usuarioObj.setContrasenha(usuarioRequest.getContrasenha());
        usuarioObj.setMetodoEncriptacion(usuarioRequest.getMetodoEncriptacion());
        return usuarioObj;
    }
}
