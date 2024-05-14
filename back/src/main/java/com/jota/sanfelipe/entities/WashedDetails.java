package com.jota.sanfelipe.entities;

import java.util.Date;

public class WashedDetails {
    private String client;
    private String employee;
    private String carPlate;
    private double total;
    private Date date;


    public WashedDetails(String client, String employee, String carPlate, double total, Date date) {
        this.client = client;
        this.employee = employee;
        this.carPlate = carPlate;
        this.total = total;
        this.date = date;
    }
    // Getters y setters
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
