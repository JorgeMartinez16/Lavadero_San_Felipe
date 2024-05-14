package com.jota.sanfelipe.controllers;

import com.jota.sanfelipe.entities.Client;
import com.jota.sanfelipe.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> findAll() {
        return clientService.getAllClients();
    }

    @PostMapping("/register")
    public ResponseEntity<Client> registerClient(@RequestBody Client client) {
        Client savedClient = clientService.registerClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

}
