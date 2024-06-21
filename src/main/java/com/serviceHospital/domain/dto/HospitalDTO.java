package com.serviceHospital.domain.dto;

import com.serviceHospital.domain.Hospital;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HospitalDTO {

    private Long id;

    private String name;

    private String age;

    private String disease;


    public HospitalDTO(Hospital hospital) {
        this.id = hospital.getId();
        this.name = hospital.getName();
        this.age = hospital.getAge();
        this.disease = hospital.getDisease();
    }
}
