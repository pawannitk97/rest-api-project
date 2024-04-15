package com.example.restapiproject.models;
import jakarta.persistence.*;


@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int car_id;

    private String make;
    private String model;
    private int makeYear;
    private String color;

    @ManyToOne
    @JoinColumn(name = "owner_id",insertable = false, updatable = false)
    private Owner owner;
    private int  owner_id;

    public int getCarId() {
        return car_id;
    }

    public void setCarId(int carId) {
        this.car_id = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return makeYear;
    }

    public void setYear(int makeYear) {
        this.makeYear = makeYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getOwnerId() {
        return owner_id;
    }

    public void setOwnerId(int ownerId) {
        this.owner_id = ownerId;
    }
}
