package com.jota.sanfelipe.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="washed-service")
public class Washed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long client_id;
    private Long car_id;
    private Long employeeId;
    private List<Long> services_id;
    private final Date date;

    public Washed() {
        this.date = new Date();
    }


    public Long getId() {
        return id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getCar_id() {
        return car_id;
    }

    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }

    public Long getEmployee_id() {
        return employeeId;
    }

    public void setEmployee_id(Long employee_id) {
        this.employeeId = employee_id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public List<Long> getServices_id() {
        return services_id;
    }

    public void setServices_id(List<Long> services_id) {
        this.services_id = services_id;
    }

    public Date getDate() {
        return date;
    }
}

