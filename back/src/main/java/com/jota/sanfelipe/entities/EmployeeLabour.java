package com.jota.sanfelipe.entities;

import java.util.Date;
import java.util.List;

public class EmployeeLabour {

    public EmployeeLabour(List<String> services, String car_plate, String client, Double services_price, Date date) {
        this.services = services;
        this.car_plate = car_plate;
        this.client = client;
        this.services_price= services_price;
        this.date=date;
    }

    private List<String> services;
    private String car_plate;
    private String client;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getServices_price() {
        return services_price;
    }

    public void setServices_price(double services_price) {
        this.services_price = services_price;
    }

    private double services_price;

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

}
