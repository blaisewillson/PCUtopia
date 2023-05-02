package com.pcutopia.pcutopia;

import java.util.Arrays;

public class PSUPart extends PCComponent {
    private int wattage;

    public PSUPart(String name, String manufacturer, int modelNumber, float[] dimensions, float price, int wattage) {
        super(name, manufacturer, modelNumber, dimensions, price);
        this.wattage = wattage;
    }

    public int getWattage() {
        return this.wattage;
    }

    @Override
    public String toString() {
        String Output = this.name + "\n" + this.manufacturer + "\n" + this.modelNumber + "\n" + this.dimensions[0] + "\n" + this.dimensions[1] + "\n" + this.dimensions[2] + "\n" + this.price + "\n" + this.wattage + "\n-------";
        return Output;
    }
}
