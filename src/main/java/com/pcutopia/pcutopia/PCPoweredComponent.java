package com.pcutopia.pcutopia;

import java.util.Arrays;

public class PCPoweredComponent extends PCComponent{
    protected int wattage;

    public PCPoweredComponent(String name, String manufacturer, int modelNumber, float[] dimensions, float price, int wattage) {
        super(name, manufacturer, modelNumber, dimensions, price);
        this.wattage = wattage;
    }

    public PCPoweredComponent() {
        super();
    }

    public int getWattage() {
        return this.wattage;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", modelNumber=" + modelNumber +
                ", dimensions=" + Arrays.toString(dimensions) +
                ", price=" + price +
                ", wattage= " + wattage +
                '}';
    }
}

