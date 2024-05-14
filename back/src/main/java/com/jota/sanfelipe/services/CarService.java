package com.jota.sanfelipe.services;

import com.jota.sanfelipe.entities.Car;
import com.jota.sanfelipe.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car registerCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void deleteCarByLicencePlate(String licencePlate) {
        Car car = carRepository.findByLicencePlate(licencePlate);
        carRepository.delete(car);
    }

}
