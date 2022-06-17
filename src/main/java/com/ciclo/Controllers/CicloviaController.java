package com.ciclo.Controllers;

import java.util.List;

import com.ciclo.Dto.CalificacionRequestDto;
import com.ciclo.Dto.CalificacionResponseDto;
import com.ciclo.Dto.CicloviaRequestDto;
import com.ciclo.Dto.CicloviaResponseDto;
import com.ciclo.Dto.ReportRequest;
import com.ciclo.Dto.ReportResponse;
import com.ciclo.Entities.Calificacion;
import com.ciclo.Entities.Ciclovia;
import com.ciclo.Entities.Report;
import com.ciclo.Services.CicloviaService;
import com.ciclo.Util.EntityDtoConverter;
import com.ciclo.Util.ReportDtoConverter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ciclovia")
public class CicloviaController {
    private CicloviaService cicloviaService;
    private EntityDtoConverter converter;
    private ReportDtoConverter reportConverter;
    public CicloviaController(CicloviaService cicloviaService, EntityDtoConverter converter, ReportDtoConverter reportConverter) {
        this.cicloviaService = cicloviaService;
        this.converter = converter;
        this.reportConverter = reportConverter;
    }

    @PostMapping
    public ResponseEntity<CicloviaResponseDto> createCiclovia(@RequestBody CicloviaRequestDto ciclovia){
        Ciclovia cicloviaCreated = cicloviaService.createCiclovia(ciclovia);
        return new ResponseEntity<>(converter.convertEntityToDto(cicloviaCreated), HttpStatus.CREATED);
    }

    @GetMapping("list")
	public ResponseEntity<List<CicloviaResponseDto>> listAllCiclovias() {
		List<Ciclovia> response = cicloviaService.listAllCiclovias();
		return new ResponseEntity<>(converter.convertCicloviasToDto(response), HttpStatus.OK);
	}

    @GetMapping("/{cicloviaId}")
    public ResponseEntity<CicloviaResponseDto> findCicloviaById(@PathVariable Long cicloviaId){
        Ciclovia ciclovia = cicloviaService.getCicloviaById(cicloviaId);
        return new ResponseEntity<>(converter.convertEntityToDto(ciclovia), HttpStatus.OK);
    }

    @PostMapping("/{cicloviaId}/calificaciones")
    public ResponseEntity<CalificacionResponseDto> createCalificacion(@PathVariable Long cicloviaId, @RequestBody CalificacionRequestDto calificacion){
        Calificacion calificacionCreated = cicloviaService.createCalificacion(cicloviaId, calificacion);
        return new ResponseEntity<>(converter.convertEntityToDto(calificacionCreated), HttpStatus.CREATED);
    }

    @PostMapping("/{cicloviaId}/reports")
    public ResponseEntity<ReportResponse> createReport(@PathVariable Long cicloviaId, @RequestBody ReportRequest report){
        Report reportCreated = cicloviaService.createReport(cicloviaId, report);
        return new ResponseEntity<>(reportConverter.convertReportToDto(reportCreated), HttpStatus.CREATED);
    }

    @GetMapping("/{cicloviaId}/calificaciones")
    public ResponseEntity<List<CalificacionResponseDto>> getCalificacionesById(@PathVariable Long cicloviaId){
        List<Calificacion> calificacion = cicloviaService.getCalificacionesById(cicloviaId);
        return new ResponseEntity<>(converter.convertEntityToDto(calificacion), HttpStatus.OK);
    }

    @GetMapping("/{cicloviaId}/reports")
    public ResponseEntity<List<ReportResponse>> getReportesById(@PathVariable Long cicloviaId){
        List<Report> reports = cicloviaService.getReportsById(cicloviaId);
        return new ResponseEntity<>(reportConverter.convertReportToDto(reports), HttpStatus.OK);
    }

    @GetMapping("/calificaciones/{calificacionId}")
    public ResponseEntity<CalificacionResponseDto> getCalificacionById(@PathVariable Long calificacionId){
        Calificacion calificacion = cicloviaService.getCalificacionById(calificacionId);
        return new ResponseEntity<>(converter.convertEntityToDto(calificacion), HttpStatus.OK);
    }
    
    @GetMapping("/{cicloviaId}/calificaciones/promedio")
    public ResponseEntity<Float> getCalificacionPromedioById(@PathVariable Long cicloviaId){
        Float calificacionMessage = cicloviaService.getAverageCalificacionById(cicloviaId);
        return new ResponseEntity<>(calificacionMessage, HttpStatus.OK);
    }
    
}
