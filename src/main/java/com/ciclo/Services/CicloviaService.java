package com.ciclo.Services;

import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.CicloviaRequestDto;
import com.ciclo.Dto.CicloviaResponseDto;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Repositories.CalificacionRepository;
import com.ciclo.Repositories.CicloviaRepository;
import com.ciclo.Util.CalificacionValidator;
import com.ciclo.Util.CicloviaValidator;
import com.ciclo.Util.EntityDtoConverter;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

@Service
public class CicloviaService {
	private CicloviaRepository cicloviaRepository;
	private CalificacionRepository calificacionRepository;
	private EntityDtoConverter entityDtoConverter;

	public CicloviaService(CicloviaRepository cicloviaRepository, CalificacionRepository calificacionRepository,
			EntityDtoConverter entityDtoConverter) {
		this.cicloviaRepository = cicloviaRepository;
		this.calificacionRepository = calificacionRepository;
		this.entityDtoConverter = entityDtoConverter;
	}

	public Ciclovia createCiclovia(CicloviaRequestDto cicloviaDto) {
		CicloviaValidator.validateCreate(cicloviaDto);
		Ciclovia ciclovia = new Ciclovia(cicloviaDto);
		return cicloviaRepository.save(ciclovia);
	}

	@Transactional
	public Calificacion createCalificacion(Long idCiclovia, CalificacionRequestDto calificacionDto) {
		CalificacionValidator.validateCreate(calificacionDto);
		Ciclovia ciclovia = getCicloviaById(idCiclovia);
		CicloviaValidator.validateGetByCiclovia(ciclovia);
		Calificacion calificacion = new Calificacion(ciclovia, calificacionDto);
		return calificacionRepository.save(calificacion);
	}

	@Transactional(readOnly = true)
	public Ciclovia getCicloviaById(Long idCiclovia) {
		Ciclovia ciclovia = cicloviaRepository.findCicloviaByCicloviaId(idCiclovia);
		CicloviaValidator.validateGetByCiclovia(ciclovia);
		return ciclovia;
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
		CicloviaValidator.validateGetByCiclovia(cicloviaRepository.findCicloviaByCicloviaId(idCiclovia));
		return calificacionRepository.getAverageCalificacionByCicloviaId(idCiclovia);
	}

	public List<CicloviaResponseDto> getAllCiclovias() {
		List<Ciclovia> ciclovias = cicloviaRepository.findAll();
		return entityDtoConverter.convertEntityToDtoList(ciclovias);
	}
}
