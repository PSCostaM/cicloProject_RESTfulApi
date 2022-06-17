package com.ciclo.Services;

import java.util.Date;
import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.CicloviaRequestDto;
import com.ciclo.Dto.ReportRequest;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Entities.Report;
import com.ciclo.Repositories.CalificacionRepository;
import com.ciclo.Repositories.CicloviaRepository;
import com.ciclo.Repositories.ReportRepository;
import com.ciclo.Util.CalificacionValidator;
import com.ciclo.Util.CicloviaValidator;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

@Service
public class CicloviaService {
    private CicloviaRepository cicloviaRepository;
    private CalificacionRepository calificacionRepository;
    private ReportRepository reportRepository;

    public CicloviaService(CicloviaRepository cicloviaRepository, CalificacionRepository calificacionRepository, ReportRepository reportRepository) {
        this.cicloviaRepository = cicloviaRepository;
        this.calificacionRepository = calificacionRepository;
        this.reportRepository = reportRepository;
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
        Calificacion calificacion = new Calificacion(ciclovia , calificacionDto);
        return calificacionRepository.save(calificacion);
    }

    @Transactional
    public Report createReport(Long idCiclovia, ReportRequest requestDto) {
        // CalificacionValidator.validateCreate(calificacionDto);
        Ciclovia ciclovia = getCicloviaById(idCiclovia);
        CicloviaValidator.validateGetByCiclovia(ciclovia);
        Report reportObj = new Report();
        reportObj.setDateReport(new Date());
        reportObj.setDescription(requestDto.getDescription());
        reportObj.setIdUser(requestDto.getIdUser());
        reportObj.setCiclovia(ciclovia);
        return reportRepository.save(reportObj);
    }
    
    @Transactional(readOnly = true)
    public Ciclovia getCicloviaById(Long idCiclovia) {
        Ciclovia ciclovia =  cicloviaRepository.findCicloviaByCicloviaId(idCiclovia);
        CicloviaValidator.validateGetByCiclovia(ciclovia);
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

    @Transactional
    public List<Report> getReportsById(Long idCiclovia) {
        CicloviaValidator.validateGetByCiclovia(cicloviaRepository.findCicloviaByCicloviaId(idCiclovia));
        return reportRepository.getReportsById(idCiclovia);
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


