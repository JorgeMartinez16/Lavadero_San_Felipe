package com.jota.sanfelipe.entities;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="licencePlate")
    private String licencePlate;
    @Column(name="make")
    private String make;
    @Column(name="color")
    private String color;

   /* @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @OneToMany(mappedBy="car")
    private List<Washed> washedList;*/


    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
