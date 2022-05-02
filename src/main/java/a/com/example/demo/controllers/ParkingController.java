package a.com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import a.com.example.demo.dto.EstacionamientoRequest;
import a.com.example.demo.dto.EstacionamientoResponse;
import a.com.example.demo.entities.Estacionamiento;
import a.com.example.demo.services.ParkingService;
import a.com.example.demo.util.EntityDtoConverter;


@RestController
@RequestMapping("/estacionamiento")
public class ParkingController {
    private ParkingService parkingService;
    private EntityDtoConverter converter;

    public ParkingController(ParkingService parkingService, EntityDtoConverter converter){
        this.parkingService = parkingService;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<EstacionamientoResponse> createParking(@RequestBody EstacionamientoRequest request){
        Estacionamiento parking = parkingService.createParking(request);
        return new ResponseEntity<>(converter.convertEntityToDto(parking), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<EstacionamientoResponse>> findParking() {
        List<Estacionamiento> parking = parkingService.getNotFullParking();
        return new ResponseEntity<>(converter.convertEntityToDto(parking), HttpStatus.OK);
    }
    
}
