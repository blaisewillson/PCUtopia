package com.pcutopia.pcutopia;

public class MOBOPart extends PCComponent {
    private String formFactor;
    private String CPU_socket;
    private float RAM_slots;
    private String RAM_type;
    private String color;
    private float PCIE_slots;
    private float m2_slots;
    private float Sata_ports;
    private float USB_ports;
    private float Network_type;
    private float PCIE_version;

    public MOBOPart(String name, String manufacturer, int modelNumber, float[] dimensions,
                    float price, String formFactor, String CPU_socket, float RAM_slots,
                    String RAM_type, String color, float PCIE_slots, float m2_slots,
                    float Sata_ports, float USB_ports, float Network_type, float PCIE_version) {
        super(name, manufacturer, modelNumber, dimensions, price);
        this.formFactor = formFactor;
        this.CPU_socket = CPU_socket;
        this.RAM_slots = RAM_slots;
        this.RAM_type = RAM_type;
        this.color = color;
        this.PCIE_slots = PCIE_slots;
        this.m2_slots = m2_slots;
        this.Sata_ports = Sata_ports;
        this.USB_ports = USB_ports;
        this.Network_type = Network_type;
        this.PCIE_version = PCIE_version;
    }

    @Override
    public String toString() {
        String Output = this.name + "\n" + this.manufacturer + "\n" + this.modelNumber + "\n" + this.dimensions[0] + "\n" + this.dimensions[1] + "\n" + this.dimensions[2] + "\n" + this.price + "\n" +
                this.formFactor + "\n" + this.CPU_socket + "\n" + this.RAM_slots + "\n" + this.RAM_type + "\n" + this.color + "\n" + this.PCIE_slots + "\n" + this.m2_slots + "\n" + this.Sata_ports + "\n" +
                this.USB_ports + "\n" + this.Network_type + "\n" + this.PCIE_version + "\n-------";
        return Output;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "formFactor='" + formFactor + '\'' +
//                ", CPU_socket='" + CPU_socket + '\'' +
//                ", RAM_slots=" + RAM_slots +
//                ", RAM_type='" + RAM_type + '\'' +
//                ", color='" + color + '\'' +
//                ", PCIE_slots=" + PCIE_slots +
//                ", m2_slots=" + m2_slots +
//                ", Sata_ports=" + Sata_ports +
//                ", USB_ports=" + USB_ports +
//                ", Network_type=" + Network_type +
//                ", PCIE_version=" + PCIE_version +
//                '}';
//    }
}