package com.serviceHospital.domain.dto;

import com.serviceHospital.domain.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDTO {

    private  Long id;

    private  String name;

    private  String contact;

    private Long hospitalId;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.contact = client.getContact();
        if (client.getHospitalId() != null) {
            this.hospitalId = client.getHospitalId().getId();
        }
    }
}

