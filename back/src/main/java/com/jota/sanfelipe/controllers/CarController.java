package com.jota.sanfelipe.controllers;

import com.jota.sanfelipe.entities.Car;
import com.jota.sanfelipe.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> findAll() {
        return carService.getAllCars();
    }

    @PostMapping("/register")
    public ResponseEntity<Car> registerCar(@RequestBody Car car) {
        Car savedCar = carService.registerCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @DeleteMapping("/{licencePlate}")
    public ResponseEntity<String> deleteCar(@PathVariable("licencePlate") String licencePlate){
        carService.deleteCarByLicencePlate(licencePlate);
        return ResponseEntity.ok("Car deleted successfully with licence plate: " + licencePlate);
    }

}
