package com.example.transport.service;

import com.example.transport.Repository.Repo;
import com.example.transport.entity.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.transport.Repository.Repo.*;

@Service
public class TransportService {

    @Autowired
    Repo repo;

    public void addTransport(Transport transport){
        repo.save(transport);

    }

    public Iterable<Transport> findTransport(String brand, String model, String category, String licenseNumber, String releaseYear){
        Iterable<Transport> transports= repo.findAll(hasBrand(brand).and(hasModel(model)).and(hasCategory(category).and(hasLicenseNumber(licenseNumber).and(hasReleaseYear(releaseYear)))));;
        return transports;
    }



}
