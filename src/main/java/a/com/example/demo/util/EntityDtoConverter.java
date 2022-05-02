package a.com.example.demo.util;

import java.util.List;
import java.util.stream.Collectors;

import a.com.example.demo.dto.EstacionamientoResponse;
import a.com.example.demo.entities.Estacionamiento;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {
    
    //inyección de dependencias DI
    private ModelMapper modelMapper;

    public EntityDtoConverter(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public EstacionamientoResponse convertEntityToDto(Estacionamiento parking){
        return modelMapper.map(parking, EstacionamientoResponse.class);
    }

    public List<EstacionamientoResponse> convertEntityToDto(List<Estacionamiento> parkings){
        return parkings.stream()
        .map(parking->convertEntityToDto(parking))
        .collect(Collectors.toList());
    }

    
}

