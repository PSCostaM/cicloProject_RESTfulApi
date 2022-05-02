package com.ciclo.Util;

import java.util.List;
import com.ciclo.Dto.RutaResponse;
import com.ciclo.Entities.Ruta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RutaDtoConverter {
    private ModelMapper modelMapper;

    public RutaDtoConverter(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    public RutaResponse convertRutaToDto(Ruta ruta){
        return modelMapper.map(ruta, RutaResponse.class);
    }

    public List<RutaResponse> convertRutaToDto(List<Ruta> rutas) {
        return rutas.stream()
                .map(ruta->convertRutaToDto(ruta))
                .collect(Collectors.toList());
    }
}
