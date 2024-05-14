package com.jota.sanfelipe.repository;

import com.jota.sanfelipe.entities.AvalaibleService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvalaibleServiceRepository extends JpaRepository<AvalaibleService, Long> {
    AvalaibleService findByName (String name);


}
