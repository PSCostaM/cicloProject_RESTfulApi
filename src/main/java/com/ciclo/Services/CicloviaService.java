package com.ciclo.Services;

import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.CicloviaRequestDto;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Repositories.CalificacionRepository;
import com.ciclo.Repositories.CicloviaRepository;
import com.ciclo.Util.CalificacionValidator;
import com.ciclo.Util.CicloviaValidator;

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
        CicloviaValidator.validateCreate(cicloviaDto);
        Ciclovia ciclovia = getCicloviaByName(cicloviaDto.getNombreCiclovia());
        CicloviaValidator.validateCicloviaName(ciclovia);
        ciclovia = new Ciclovia(cicloviaDto);
        return cicloviaRepository.save(ciclovia);
    }

    @Transactional
    public Calificacion createCalificacion(Long idCiclovia, CalificacionRequestDto calificacionDto) {
        CalificacionValidator.validateCreate(calificacionDto);
        Ciclovia ciclovia = getCicloviaById(idCiclovia);
        CicloviaValidator.validateGetByCiclovia(ciclovia);
        Calificacion calificacion = new Calificacion(ciclovia , calificacionDto);
        return calificacionRepository.save(calificacion);
    }
    
    @Transactional(readOnly = true)
    public Ciclovia getCicloviaById(Long idCiclovia) {
        Ciclovia ciclovia =  cicloviaRepository.findCicloviaByCicloviaId(idCiclovia);
        CicloviaValidator.validateGetByCiclovia(ciclovia);
        return ciclovia;
    }

    public Ciclovia getCicloviaByName(String nombreCiclovia) {
        Ciclovia ciclovia = cicloviaRepository.findCicloviaByCicloviaName(nombreCiclovia);
        return ciclovia;
    }

    public List<Ciclovia> listAllCiclovias() {
		return cicloviaRepository.findAll();
	}

    @Transactional
    public List<Calificacion> getCalificacionesById(Long idCiclovia) {
        CicloviaValidator.validateGetByCiclovia(cicloviaRepository.findCicloviaByCicloviaId(idCiclovia));
        return calificacionRepository.getCalificacionesById(idCiclovia);
    }

    public Calificacion getCalificacionById(Long idCalificacion) {
        Calificacion calificacion = calificacionRepository.findCalificacionByCalificacionId(idCalificacion);
        CalificacionValidator.validateGetCalificacion(calificacion);
        return calificacion;
    }

    @Transactional
    public Float getAverageCalificacionById(Long idCiclovia) {
        if(calificacionRepository.getCalificacionesById(idCiclovia).size() == 0) return 0.0f;
        CicloviaValidator.validateGetByCiclovia(cicloviaRepository.findCicloviaByCicloviaId(idCiclovia));
        return calificacionRepository.getAverageCalificacionByCicloviaId(idCiclovia);        
    }
}


