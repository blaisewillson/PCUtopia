package com.pcutopia.pcutopia;

import java.util.Arrays;


public class PCComponent {
    protected String name;
    protected String manufacturer;
    protected int modelNumber;
    protected float[] dimensions;
    protected double price;

    public PCComponent(String name, String manufacturer, int modelNumber, float[] dimensions, float price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.modelNumber = modelNumber;
        this.dimensions = dimensions;
        this.price = price;
    }

    public PCComponent() {

    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelNumber() {
        String output = Integer.toString(this.modelNumber);
        return output;
    }

    public float[] getDimensions() {
        return dimensions;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", modelNumber=" + modelNumber +
                ", dimensions=" + Arrays.toString(dimensions) +
                ", price=" + price +
                '}';
    }
}
