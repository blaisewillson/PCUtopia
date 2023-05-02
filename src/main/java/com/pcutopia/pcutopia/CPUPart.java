package com.pcutopia.pcutopia;

public class CPUPart extends PCPoweredComponent {
    private float num_cores;
    private float num_threads;
    private double clock_speed;
    private float cache;
    private String socket;
    private float PCIE_lanes;
    private float PCIE_ver;

    public CPUPart(String name, String manufacturer, int modelNumber, float[] dimensions, float price, int wattage,
                   float num_cores, float num_threads, double clock_speed, float cache, String socket, float PCIE_lanes, float PCIE_ver){
        super(name, manufacturer, modelNumber, dimensions, price, wattage);
        this.num_cores = num_cores;
        this.num_threads = num_threads;
        this.clock_speed = clock_speed;
        this.cache = cache;
        this.socket = socket;
        this.PCIE_lanes = PCIE_lanes;
        this.PCIE_ver = PCIE_ver;
    }

    public float getNum_cores() {
        return num_cores;
    }

    public float getNum_threads() {
        return num_threads;
    }

    public double getClock_speed() {
        return clock_speed;
    }

    public float getCache() {
        return cache;
    }

    public String getSocket() {
        return socket;
    }

    public float getPCIE_lanes() {
        return PCIE_lanes;
    }

    public float getPCIE_ver() {
        return PCIE_ver;
    }

    @Override
    public String toString() {
        String Output = this.name + "\n" + this.manufacturer + "\n" + this.modelNumber + "\n" + this.dimensions[0] + "\n" + this.dimensions[1] + "\n" + this.dimensions[2] + "\n" + this.price + "\n" + this.wattage + "\n" + this.num_cores + "\n" + this.num_threads + "\n" + this.clock_speed + "\n" + this.cache + "\n" + this.socket + "\n" + this.PCIE_lanes + "\n" + this.PCIE_ver + "\n-------";
        return Output;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "num_cores=" + num_cores +
//                ", num_threads=" + num_threads +
//                ", clock_speed=" + clock_speed +
//                ", cache=" + cache +
//                ", socket='" + socket + '\'' +
//                ", PCIE_lanes=" + PCIE_lanes +
//                ", PCIE_ver=" + PCIE_ver +
//                '}';
//    }

}

