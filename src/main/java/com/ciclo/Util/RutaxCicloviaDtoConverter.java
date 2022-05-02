package com.ciclo.Util;

import java.util.List;
import java.util.stream.Collectors;

import com.ciclo.Dto.RutaxCicloviaResponse;
import com.ciclo.Entities.RutaxCiclovia;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RutaxCicloviaDtoConverter {
    private ModelMapper modelMapper;

    public RutaxCicloviaDtoConverter(ModelMapper modelMapper) { this.modelMapper = modelMapper; }

    public RutaxCicloviaResponse convertRutaxCicloviaToDto(RutaxCiclovia rutaxCiclovia) {
        return modelMapper.map(rutaxCiclovia, RutaxCicloviaResponse.class);
    }

    public List<RutaxCicloviaResponse> convertRutaxCicloviaToDto(List<RutaxCiclovia> rutaxCiclovias) {
        return rutaxCiclovias.stream()
                .map(rutaxCiclovia->convertRutaxCicloviaToDto(rutaxCiclovia))
                .collect(Collectors.toList());
    }
}

