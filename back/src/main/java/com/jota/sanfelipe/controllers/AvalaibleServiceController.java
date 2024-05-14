package com.jota.sanfelipe.controllers;

import com.jota.sanfelipe.entities.AvalaibleService;
;
import com.jota.sanfelipe.services.AvalaibleServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/avalaible-service")
public class AvalaibleServiceController {
    @Autowired
    private AvalaibleServiceService avalaibleServiceService;

    @GetMapping
    public List<AvalaibleService> findAll(){
        return avalaibleServiceService.getAllAvalaibleService();
    }

    @PostMapping("register")
    public ResponseEntity<AvalaibleService> registerAvalaibleService(@RequestBody AvalaibleService avalaibleService){
        AvalaibleService savedAvalaibleService = avalaibleServiceService.registerAvalaibleService(avalaibleService);
        return new ResponseEntity<>(savedAvalaibleService, HttpStatus.CREATED);
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteAvalaibleService(@PathVariable("name") String name){
        avalaibleServiceService.deleteAvalaibleServiceByName(name);
        return ResponseEntity.ok("the service: " + name +  " has been removed ");
    }


}
