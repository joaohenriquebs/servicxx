package com.serviceHospital.domain;

import com.serviceHospital.domain.dto.HospitalDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String age;

    private String disease;

    public Hospital(HospitalDTO hospitalDTO) {
        super();
        this.id = hospitalDTO.getId();
        this.name = hospitalDTO.getName();
        this.age = hospitalDTO.getAge();
        this.disease = hospitalDTO.getDisease();
    }
}
