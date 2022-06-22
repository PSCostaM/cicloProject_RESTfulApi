package com.ciclo.Services;

import com.ciclo.Repositories.RutaRepository;
import com.ciclo.Util.RutaValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ciclo.Dto.RutaRequest;
import com.ciclo.Entities.Ruta;

import java.util.ArrayList;
import java.util.List;

@Service
public class RutaService {
    private RutaRepository rutaRepository;
    public RutaService(RutaRepository rutaRepository) {this.rutaRepository = rutaRepository;}

    @Transactional
    public Ruta createRuta(RutaRequest rutaRequest) {
        RutaValidator.validateCreate(rutaRequest);
        Ruta rutaNew = initRuta(rutaRequest);
        return rutaRepository.save(rutaNew);
    }

    private Ruta initRuta(RutaRequest rutaRequest) {
        Ruta rutaObj = new Ruta();
        rutaObj.setUbicacionSalida(rutaRequest.getUbicacionSalida());
        rutaObj.setUbicacionLlegada(rutaRequest.getUbicacionLlegada());
        rutaObj.setFlagTerminado(false);
        rutaObj.setIdUser(rutaRequest.getIdUser());
        return rutaObj;
    }

    public List<Ruta> getRutasByUsuario(Long idUser) { return rutaRepository.getRutasxUser(idUser); }

    public List<Ruta> getAllRutas() { return rutaRepository.getAllRutas(); }

    public List<Ruta> getRutasxPuntos(String ubicacionSalida, String ubicacionLlegada) { return rutaRepository.getRutasxPuntos(ubicacionSalida,ubicacionLlegada); }
}
