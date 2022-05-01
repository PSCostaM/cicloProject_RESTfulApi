package com.ciclo.Services;

import javax.transaction.Transactional;

import com.ciclo.Dto.CicloviaDto;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Repositories.CicloviaRepository;

import org.springframework.stereotype.Service;

@Service
public class CicloviaService {
    private CicloviaRepository cicloviaRepository;

    @Transactional
    public Ciclovia createCiclovia(CicloviaDto cicloviaDto) {
        Ciclovia ciclovia = initCiclovia(cicloviaDto);
        return ciclovia;
    }

    @Transactional
    public String updateCalificacionCiclovia(Long idCiclovia, float calificacion) {
        cicloviaRepository.updateCalificacion(idCiclovia, calificacion);
		return String.format("Now bikeway %s is %d stars", idCiclovia, calificacion);
	} 

    public float getCalificacionById(Long idCiclovia) {
        return cicloviaRepository.findCalificacionById(idCiclovia);
    }

    private Ciclovia initCiclovia(CicloviaDto cicloviaDto) {
        Ciclovia ciclovia = new Ciclovia();
        ciclovia.setCalificacionCiclovia(cicloviaDto.getCalificacionCiclovia());
        return cicloviaRepository.save(ciclovia);
    }
}


