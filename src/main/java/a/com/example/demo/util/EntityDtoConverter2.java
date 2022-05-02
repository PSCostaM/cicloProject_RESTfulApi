package a.com.example.demo.util;

import java.util.List;
import java.util.stream.Collectors;

import a.com.example.demo.dto.CalificacionResponse;
import a.com.example.demo.entities.Calificacion;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter2 {

    private ModelMapper modelMapper;

    public EntityDtoConverter2(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public CalificacionResponse convertEntityToDto2(Calificacion calificacion){
        return modelMapper.map(calificacion, CalificacionResponse.class);
    }

    public List<CalificacionResponse> convertEntityToDto2(List<Calificacion> calificaciones){
        return calificaciones.stream()
        .map(calificacione->convertEntityToDto2(calificacione))
        .collect(Collectors.toList());
    }
}
