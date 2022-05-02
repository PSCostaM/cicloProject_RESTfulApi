package a.com.example.demo.util;

import java.util.List;
import java.util.stream.Collectors;

import a.com.example.demo.dto.UsuarioResponse;
import a.com.example.demo.entities.Usuario;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {
    private ModelMapper modelMapper;

    public EntityDtoConverter(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public UsuarioResponse convertEntityToDto(Usuario usuario){
        return modelMapper.map(usuario, UsuarioResponse.class);
    }

    public List<UsuarioResponse> convertEntityToDto(List<Usuario> usuarios){
        return usuarios.stream()
                .map(usuarios->convertEntityToDto(usuarios))
                .collect(Collectors.toList());
    }
}
