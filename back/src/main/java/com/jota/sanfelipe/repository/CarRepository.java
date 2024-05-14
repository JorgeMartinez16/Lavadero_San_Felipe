package com.jota.sanfelipe.repository;

import com.jota.sanfelipe.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByLicencePlate(String licencePlate);

}
