package com.pcutopia.pcutopia;

import java.util.Arrays;

public class RAMPart extends PCComponent{
    private float size;
    private float speed;
    private float DIMS;

    public RAMPart(String name, String manufacturer, int modelNumber, float[] dimensions, float price, float size, float speed, float DIMS) {
        super(name, manufacturer, modelNumber, dimensions, price);
        this.size = size;
        this.speed = speed;
        this.DIMS = DIMS;
    }

    @Override
    public String toString() {
        String Output = this.name + "\n" + this.manufacturer + "\n" + this.modelNumber + "\n" + this.dimensions[0] + "\n" + this.dimensions[1] + "\n" + this.dimensions[2] + "\n" + this.price + "\n" + this.size + "\n" + this.speed + "\n" + this.DIMS + "\n-------";
        return Output;
    }
}
