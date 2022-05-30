package com.ciclo.Util;

import java.util.List;
import java.util.stream.Collectors;

import com.ciclo.Dto.CalificacionResponseDto;
import com.ciclo.Dto.CicloviaResponseDto;
import com.ciclo.Dto.ParkingDto;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Entities.Parking;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {

    private ModelMapper modelMapper;

    public EntityDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    
    public CicloviaResponseDto convertEntityToDto(Ciclovia ciclovia) {
        return modelMapper.map(ciclovia, CicloviaResponseDto.class);
    }

    public CalificacionResponseDto convertEntityToDto(Calificacion calificacion) {
        return modelMapper.map(calificacion, CalificacionResponseDto.class);
    }

    public List<CalificacionResponseDto> convertEntityToDto(List<Calificacion> reports) {
        return reports.stream()
                .map(report -> convertEntityToDto(report))
                .collect(Collectors.toList());
    }

    public ParkingDto convertEntityToDto2(Parking parking){
        return modelMapper.map(parking, ParkingDto.class); 
    }
}
