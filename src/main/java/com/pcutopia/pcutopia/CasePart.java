package com.pcutopia.pcutopia;

public class CasePart extends PCComponent {
    public CasePart(String name, String manufacturer, int modelNumber, float[] dimensions, float price) {
        super(name, manufacturer, modelNumber, dimensions, price);
    }

    @Override
    public String toString() {
        String Output = this.name + "\n" + this.manufacturer + "\n" + this.modelNumber + "\n" + this.dimensions[0] +
                "\n" + this.dimensions[1] + "\n" + this.dimensions[2] + "\n" + this.price + "\n-------";
        return Output;
    }
}
