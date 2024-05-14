package com.jota.sanfelipe.services;

import com.jota.sanfelipe.entities.*;
import com.jota.sanfelipe.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WashedService {
    @Autowired
    private WashedRepository washedRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private AvalaibleServiceRepository avalaibleServiceRepository;

    private double calculateTotalPrice(List<Long> services_id) {
        double totalPrice = 0.0;

        for (Long service_id : services_id) {
            Optional<AvalaibleService> service = avalaibleServiceRepository.findById(service_id);
            totalPrice += service.get().getPrice();
        }

        return totalPrice;
    }

    public Washed registerWashed(Washed washed){
        return washedRepository.save(washed);
    }

    public List<WashedDetails> getAllWasheds(){
        List<Washed> washeds = washedRepository.findAll();
        return washeds.stream().map(this::mapToWashedDetails).collect(Collectors.toList());
    }

    private WashedDetails mapToWashedDetails(Washed washed) {
        Optional<Client> client = clientRepository.findById(washed.getClient_id());
        Optional<Employee> employee = employeeRepository.findById(washed.getEmployee_id());
        Optional<Car> car = carRepository.findById(washed.getCar_id());

        return new WashedDetails(
                client.map(value -> value.getName() + " " + value.getLastName()).orElse(""),
                employee.map(employee1 -> employee1.getName() + " " + employee1.getLastName()).orElse(""),
                car.isPresent() ? car.get().getLicencePlate() : "",
                calculateTotalPrice(washed.getServices_id()),
                washed.getDate()
        );
    }
}
