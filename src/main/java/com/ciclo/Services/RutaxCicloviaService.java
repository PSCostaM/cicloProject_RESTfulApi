package com.ciclo.Services;

import com.ciclo.Repositories.RutaxCicloviaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ciclo.Dto.RutaxCicloviaRequest;
import com.ciclo.Entities.RutaxCiclovia;
import com.ciclo.Util.RutaxCicloviaValidator;
import java.util.List;

@Service
public class RutaxCicloviaService {
    private RutaxCicloviaRepository rutaxCicloviaRepository;
    public RutaxCicloviaService(RutaxCicloviaRepository rutaxCicloviaRepository) { this.rutaxCicloviaRepository = rutaxCicloviaRepository; }

    @Transactional
    public RutaxCiclovia createRutaxCiclovia(RutaxCicloviaRequest rutaxCicloviaRequest) {
        RutaxCiclovia rutaxCicloviaNew = initRutaxCiclovia(rutaxCicloviaRequest);
        return rutaxCicloviaRepository.save(rutaxCicloviaNew);
    }

    private RutaxCiclovia initRutaxCiclovia(RutaxCicloviaRequest rutaxCicloviaRequest) {
        RutaxCiclovia rutaxCicloviaObj = new RutaxCiclovia();
        rutaxCicloviaObj.setTiempoRealizado(rutaxCicloviaRequest.getTiempoRealizado());
        rutaxCicloviaObj.setIdRuta(rutaxCicloviaRequest.getIdRuta());
        rutaxCicloviaObj.setIdCiclovia(rutaxCicloviaRequest.getIdCiclovia());
        return rutaxCicloviaObj;
    }

    public List<RutaxCiclovia> getAllTiemposByCiclovia(Long idRuta) {
        return rutaxCicloviaRepository.getTiemposByCiclovia(idRuta);
    }

    public int getTiempoByRuta(Long idRuta) {
        return rutaxCicloviaRepository.getTiempoByRuta(idRuta);
    }
    public Float getTiempoEstimado(String ubicacionSalida, String ubicacionLlegada){
        RutaxCicloviaValidator.validateCreate(ubicacionSalida,ubicacionLlegada);
        return rutaxCicloviaRepository.getTiempoEstimado(ubicacionSalida,ubicacionLlegada);
    }
}
