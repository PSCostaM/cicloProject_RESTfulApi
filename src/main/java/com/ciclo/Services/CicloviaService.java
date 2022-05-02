package com.ciclo.Services;

import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.CicloviaRequestDto;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Repositories.CalificacionRepository;
import com.ciclo.Repositories.CicloviaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CicloviaService {
	@Autowired
	private CicloviaRepository cicloviaRepository;
	@Autowired
	private CalificacionRepository calificacionRepository;

	@Transactional
	public Ciclovia createCiclovia(CicloviaRequestDto cicloviaDto) {
		Ciclovia ciclovia = new Ciclovia(cicloviaDto);
		return cicloviaRepository.save(ciclovia);
	}

	@Transactional
	public Calificacion createCalificacion(Long idCiclovia, CalificacionRequestDto calificacionDto) {
		Calificacion calificacion = new Calificacion(getCicloviaById(idCiclovia), calificacionDto);
		return calificacionRepository.save(calificacion);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Ciclovia getCicloviaById(Long idCiclovia) {
		Ciclovia ciclovia = cicloviaRepository.findById(idCiclovia).get();
		return ciclovia;
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
