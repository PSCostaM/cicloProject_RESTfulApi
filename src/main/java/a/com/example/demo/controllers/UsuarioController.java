package a.com.example.demo.controllers;
import java.util.List;

import a.com.example.demo.dto.UsuarioRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import a.com.example.demo.dto.UsuarioResponse;
import a.com.example.demo.entities.Usuario;
import a.com.example.demo.services.UsuarioService;
import a.com.example.demo.util.EntityDtoConverter;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
    private EntityDtoConverter converter;

    public UsuarioController(UsuarioService usuarioService, EntityDtoConverter converter) {
        this.usuarioService = usuarioService;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> createParking(@RequestBody UsuarioRequest request) {
        Usuario usuario = usuarioService.createUsuario(request);
        return new ResponseEntity<>(converter.convertEntityToDto(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> encontrarRutas() {
        List<Usuario> usuario = usuarioService.getAllRutas();
        return new ResponseEntity<>(converter.convertEntityToDto(usuario), HttpStatus.OK);
    }
}
