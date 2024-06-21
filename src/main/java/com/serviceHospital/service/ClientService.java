package com.serviceHospital.service;

import com.serviceHospital.domain.Client;
import com.serviceHospital.domain.Hospital;
import com.serviceHospital.domain.dto.ClientDTO;
import com.serviceHospital.repository.ClientRepository;
import com.serviceHospital.repository.HospitalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clienteRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    public Client findById(Long id) {
        Optional<Client> client = clienteRepository.findById(id);
        return client.orElse(null); // Retorna null se não encontrar o cliente
    }

    public List<Client> findAll() {
        return clienteRepository.findAll();
    }

    public Client create(ClientDTO clientDto) {
        clientDto.setId(null);
        Hospital hospital = hospitalRepository.findById(clientDto.getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital com ID " + clientDto.getHospitalId() + " não encontrado."));
        Client client = new Client(clientDto);
        if (hospital != null) {
            client.setHospitalId(hospital);
        }
        return clienteRepository.save(client);
    }

    @Transactional
    public Client update(Client client) {
        return clienteRepository.save(client);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}