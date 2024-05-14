package com.jota.sanfelipe.services;

import com.jota.sanfelipe.entities.AvalaibleService;
import com.jota.sanfelipe.entities.Car;
import com.jota.sanfelipe.entities.Employee;
import com.jota.sanfelipe.repository.AvalaibleServiceRepository;
import com.jota.sanfelipe.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvalaibleServiceService {
    @Autowired
    private AvalaibleServiceRepository avalaibleServiceRepository;

    public AvalaibleService registerAvalaibleService(AvalaibleService avalaibleService){
        return avalaibleServiceRepository.save(avalaibleService);
    }
    public List<AvalaibleService> getAllAvalaibleService(){
        return avalaibleServiceRepository.findAll();
    }


    public void deleteAvalaibleServiceByName(String name) {
        AvalaibleService avalaibleService = avalaibleServiceRepository.findByName(name);
        avalaibleServiceRepository.delete(avalaibleService);
    }
}
