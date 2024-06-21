package com.serviceHospital.service;

import com.serviceHospital.domain.Hospital;
import com.serviceHospital.domain.dto.HospitalDTO;
import com.serviceHospital.repository.ClientRepository;
import com.serviceHospital.repository.HospitalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Hospital> getAllCars() {
        return hospitalRepository.findAll();
    }

    public Hospital findById(Long id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        return optionalHospital.orElse(null);
    }

    public Hospital create(HospitalDTO hospitalDTO) {
        hospitalDTO.setId(null);
        Hospital hospital = new Hospital(hospitalDTO);
        return hospitalRepository.save(hospital);
    }

    public Hospital updateHospital(Long id, Hospital hospital) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if (optionalHospital.isPresent()) {
            Hospital responseHospital = optionalHospital.get();
            BeanUtils.copyProperties(hospital, responseHospital);
            return hospitalRepository.save(responseHospital);
        } else {
            return null;
        }
    }

    public boolean deleteHospital(Long id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        if (optionalHospital.isPresent()) {
            hospitalRepository.delete(optionalHospital.get());
            return true;
        } else {
            return false;
        }
    }
}
