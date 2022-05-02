package com.ciclo.Services;

import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.CicloviaRequestDto;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Repositories.CalificacionRepository;
import com.ciclo.Repositories.CicloviaRepository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

@Service
public class CicloviaService {
    private CicloviaRepository cicloviaRepository;
    private CalificacionRepository calificacionRepository;

    public CicloviaService(CicloviaRepository cicloviaRepository, CalificacionRepository calificacionRepository) {
        this.cicloviaRepository = cicloviaRepository;
        this.calificacionRepository = calificacionRepository;
    }

    public Ciclovia createCiclovia(CicloviaRequestDto cicloviaDto) {
        Ciclovia ciclovia = new Ciclovia(cicloviaDto);
        return cicloviaRepository.save(ciclovia);
    }

    @Transactional
    public Calificacion createCalificacion(Long idCiclovia, CalificacionRequestDto calificacionDto) {
        Calificacion calificacion = new Calificacion(getCicloviaById(idCiclovia), calificacionDto);
        return calificacionRepository.save(calificacion);
    }
    
    @Transactional(readOnly = true)
    public Ciclovia getCicloviaById(Long idCiclovia) {
        return cicloviaRepository.findCicloviaByCicloviaId(idCiclovia);
    }

    @Transactional
    public List<Calificacion> getCalificacionesById(Long idCiclovia) {
        return calificacionRepository.getCalificacionesById(idCiclovia);
    }

    public Calificacion getCalificacionById(Long idCalificacion) {
        return calificacionRepository.findCalificacionByCalificacionId(idCalificacion);
    }

    @Transactional
    public Float getAverageCalificacionById(Long idCiclovia) {
        return calificacionRepository.getAverageCalificacionById(idCiclovia);
    }
}


