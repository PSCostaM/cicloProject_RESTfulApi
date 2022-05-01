package com.ciclo.Services;

import java.util.List;

import javax.transaction.Transactional;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.CicloviaRequestDto;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Repositories.CalificacionRepository;
import com.ciclo.Repositories.CicloviaRepository;

import org.springframework.stereotype.Service;

@Service
public class CicloviaService {
    private CicloviaRepository cicloviaRepository;
    private CalificacionRepository calificacionRepository;

    @Transactional
    public Ciclovia createCiclovia(CicloviaRequestDto cicloviaDto) {
        Ciclovia ciclovia = new Ciclovia(cicloviaDto);
        return ciclovia;
    }

    @Transactional
    public Calificacion createCalificacion(Long idCiclovia, CalificacionRequestDto calificacionDto) {
        Calificacion calificacion = new Calificacion(getCicloviaById(idCiclovia), calificacionDto);
        return calificacionRepository.save(calificacion);
    }
    
    @Transactional
    public Ciclovia getCicloviaById(Long idCiclovia) {
        return cicloviaRepository.findById(idCiclovia).get();
    }

    @Transactional
    public List<Calificacion> getCalificacionesById(Long idCiclovia) {
        return cicloviaRepository.getCalificacionesById(idCiclovia);
    }

    @Transactional
    public float getAverageCalificacionById(Long idCiclovia) {
        return cicloviaRepository.getAverageCalificacionById(idCiclovia);
    }

    public Calificacion getCalificacionxCicloviaId(Long idCiclovia, Long idCalificacion) {
        return cicloviaRepository.getCalificacionxCicloviaId(idCiclovia, idCalificacion);
    }


}


