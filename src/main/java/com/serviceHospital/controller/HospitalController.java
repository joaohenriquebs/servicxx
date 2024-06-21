package com.serviceHospital.controller;

import com.serviceHospital.domain.Hospital;
import com.serviceHospital.domain.dto.HospitalDTO;
import com.serviceHospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping
    public ResponseEntity<List<HospitalDTO>> findAll(){
        List<Hospital> carros = hospitalService.getAllCars();
        List<HospitalDTO> carrostDTOS = carros.stream()
                .map(HospitalDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(carrostDTOS);
    }

    @PostMapping
    public ResponseEntity<Hospital> save(@RequestBody HospitalDTO carrosDto) {
        Hospital carros = hospitalService.create(carrosDto);
        return new ResponseEntity<>(carros, HttpStatus.CREATED);
    }
}
