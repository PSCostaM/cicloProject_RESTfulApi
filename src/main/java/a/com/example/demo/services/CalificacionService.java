package a.com.example.demo.services;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import a.com.example.demo.dto.CalificacionRequest;
import a.com.example.demo.entities.Calificacion;
import a.com.example.demo.repository.CalificacionRepository;

@Service
public class CalificacionService {
    private CalificacionRepository calificacionRepository;
    public CalificacionService(CalificacionRepository repository){
        this.calificacionRepository = repository;
    }

    @Transactional
    public Calificacion createCalificacion(CalificacionRequest calificacionRequest){
        Calificacion calificacionNew = initCalificacion(calificacionRequest);
        return calificacionRepository.save(calificacionNew);
    }

    @Transactional(readOnly = true)
    public List<Calificacion> getBestParking(){
        return calificacionRepository.findBestParkingOrderByCalificacionDesc();
    }

    private Calificacion initCalificacion(CalificacionRequest CalificacionRequest){
        Calificacion calificacionObj = new Calificacion();
        calificacionObj.setFechacalificacion(new Date());
        calificacionObj.setEstrellas(CalificacionRequest.getEstrellas());
        calificacionObj.setDescripcionCalificacion(CalificacionRequest.getDescripcionCalificacion());
        calificacionObj.setIdEstacionamiento(CalificacionRequest.getIdEstacionamiento());
        calificacionObj.setIdUsuario(CalificacionRequest.getIdUsuario());
        calificacionObj.setIdcalificacion(CalificacionRequest.getIdcalificacion());
        return calificacionObj;
    }
}
