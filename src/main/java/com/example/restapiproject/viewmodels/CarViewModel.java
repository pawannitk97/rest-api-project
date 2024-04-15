package com.example.restapiproject.viewmodels;

import com.example.restapiproject.models.Owner;

public class CarViewModel {
    private int car_id;
    private String make;
    private String model;
    private int makeYear;
    private String color;
    private int  owner_id;
    private OwnerViewModel owner;


    public int getCarId() {
        return car_id;
    }

    public void setCarId(int car_id) {
        this.car_id = car_id;
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

    public OwnerViewModel getOwner() {
        return owner;
    }

    public void setOwner(OwnerViewModel owner) {
        this.owner = owner;
    }

    public int getOwnerId() {
        return owner_id;
    }

    public void setOwnerId(int owner_id) {
        this.owner_id = owner_id;
    }
}
