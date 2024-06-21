package com.serviceHospital.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.serviceHospital.domain.dto.ClientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    @JsonIgnoreProperties("hospital")
    private Hospital hospitalId;


    public Client(ClientDTO clientDto) {
        this.name = clientDto.getName();
        this.contact = clientDto.getContact();
        if (clientDto.getHospitalId() != null) {
            this.hospitalId = new Hospital();
            this.hospitalId.setId(clientDto.getHospitalId());
        }
    }
}

