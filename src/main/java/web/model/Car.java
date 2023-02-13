package web.model;

import web.service.CarSevice;


public class Car  {
    private String model;
    private String brand;
    private int id;

    public Car(String model, String brand, int id) {
        this.model = model;
        this.brand = brand;
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

