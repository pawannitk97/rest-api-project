package com.example.restapiproject.viewmodels;

public class CarCreateViewModel {

    private String make;
    private String model;
    private int makeYear;
    private String color;
    private int  owner_id;



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

    public int getOwnerId() {
        return owner_id;
    }

    public void setOwnerId(int owner_id) {
        this.owner_id = owner_id;
    }
}
