package com.pcutopia.pcutopia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PCBuild {
    private ArrayList<PCComponent> pcBuildComponentList = new ArrayList<>();
    private PCComponent tempPartHolder;
    private PartDatabase partDatabase;
    private CPUPart CPU;
    private GPUPart GPU;
    private PSUPart PSU;
    private MOBOPart MOBO;
    private CasePart Case;
    private RAMPart RAM;
    private int totalWattage;
    private User owner;
    private String buildName;
    private int buildID;
    private int userID;
    private double totalPrice;

    public PCBuild(){
        setBuildID();
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public void setCPU(CPUPart CPU) {
        this.CPU = CPU;
    }

    public void setGPU(GPUPart GPU) {
        this.GPU = GPU;
    }

    public void setPSU(PSUPart PSU) {
        this.PSU = PSU;
    }

    public void setMOBO(MOBOPart MOBO) {
        this.MOBO = MOBO;
    }

    public void setCase(CasePart aCase) {
        Case = aCase;
    }

    public void setRAM(RAMPart RAM) {
        this.RAM = RAM;
    }

    public PCBuild(User owner, PartDatabase partDatabase){
        this.owner = owner;
        this.partDatabase = partDatabase;
        setBuildID();
    }

    public ArrayList<PCComponent> selectCPU() {
        if(CPU != null) {
            tempPartHolder = CPU;
            CPU = null;
        }
        updateWattage();
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        ArrayList<CPUPart> cpuParts = partDatabase.getCPUs();
        for(int i = 0; i < cpuParts.size(); i++) {
            if(sizeCheck(cpuParts.get(i)) && wattageCheck(cpuParts.get(i))) {
                filteredList.add(cpuParts.get(i));
            }
        }
        return filteredList;
    }

    public ArrayList<PCComponent> selectGPU() {
        if(GPU != null) {
            tempPartHolder = GPU;
            GPU = null;
        }
        updateWattage();
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        ArrayList<GPUPart> gpuParts = partDatabase.getGPUs();
        for(int i = 0; i < gpuParts.size(); i++) {
            if(sizeCheck(gpuParts.get(i)) && wattageCheck(gpuParts.get(i))) {
                filteredList.add(gpuParts.get(i));
            }
        }
        return filteredList;
    }

    public ArrayList<PCComponent> selectMOBO() {
        if(MOBO != null) {
            tempPartHolder = MOBO;
            MOBO = null;
        }
        updateWattage();
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        ArrayList<MOBOPart> moboParts = partDatabase.getMOBOs();
        for(int i = 0; i < moboParts.size(); i++) {
            if(sizeCheck(moboParts.get(i)) && wattageCheck(moboParts.get(i))) {
                filteredList.add(moboParts.get(i));
            }
        }
        return filteredList;
    }

    public ArrayList<PCComponent> selectPSU() {
        if(PSU != null) {
            tempPartHolder = PSU;
            PSU = null;
        }
        updateWattage();
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        ArrayList<PSUPart> psuParts = partDatabase.getPSUs();
        for(int i = 0; i < psuParts.size(); i++) {
            if(sizeCheck(psuParts.get(i)) && PSUCheck(psuParts.get(i))) {
                filteredList.add(psuParts.get(i));
            }
        }
        return filteredList;
    }

    public ArrayList<PCComponent> selectCase() {
        if(Case != null) {
            tempPartHolder = Case;
            Case = null;
        }
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        ArrayList<CasePart> caseParts = partDatabase.getCase();
        for(int i = 0; i < caseParts.size(); i++) {
            if(caseCheck(caseParts.get(i))) {
                filteredList.add(caseParts.get(i));
            }
        }
        return filteredList;
    }

    public boolean addComponent(String partType, int selection){
        ArrayList<PCComponent> filteredList = new ArrayList<>();
        switch(partType.toLowerCase()) {
            case "cpu":
                filteredList.addAll(selectCPU());
                if(filteredList.size() == 0) return false;
                if(selection == -1) {
                    CPU = (CPUPart) tempPartHolder;
                    tempPartHolder = null;
                    return false;
                }
                System.out.println("Filtered CPU List:");
                for(int i = 0; i < filteredList.size(); i++) {
                    System.out.println(filteredList.get(i).toString());
                }
                System.out.println(filteredList.get(selection).name + " selected.\n");
                pcBuildComponentList.remove(this.CPU);
                CPU = (CPUPart) filteredList.get(selection);
                pcBuildComponentList.add(filteredList.get(selection));
                printBuild();
                return true;
            case "gpu":
                filteredList.addAll(selectGPU());
                if(filteredList.size() == 0) return false;
                if(selection == -1) {
                    GPU = (GPUPart) tempPartHolder;
                    tempPartHolder = null;
                    return false;
                }
                System.out.println("Filtered GPU List:");
                for(int i = 0; i < filteredList.size(); i++) {
                    System.out.println(filteredList.get(i).toString());
                }
                System.out.println(filteredList.get(selection).name + " selected.\n");
                pcBuildComponentList.remove(this.GPU);
                GPU = (GPUPart) filteredList.get(selection);
                pcBuildComponentList.add(filteredList.get(selection));
                printBuild();
                return true;
            case "psu":
                filteredList.addAll(selectPSU());
                if(filteredList.size() == 0) return false;
                if(selection == -1) {
                    PSU = (PSUPart) tempPartHolder;
                    tempPartHolder = null;
                    return false;
                }
                System.out.println("Filtered PSU List:");
                for(int i = 0; i < filteredList.size(); i++) {
                    System.out.println(filteredList.get(i).toString());
                }
                System.out.println(filteredList.get(selection).name + " selected.\n");
                pcBuildComponentList.remove(this.PSU);
                PSU = (PSUPart) filteredList.get(selection);
                pcBuildComponentList.add(filteredList.get(selection));
                printBuild();
                return true;
            case "mobo":
                filteredList.addAll(selectMOBO());
                if(filteredList.size() == 0) return false;
                if(selection == -1) {
                    MOBO = (MOBOPart) tempPartHolder;
                    tempPartHolder = null;
                    return false;
                }
                System.out.println("Filtered MOBO List:");
                for(int i = 0; i < filteredList.size(); i++) {
                    System.out.println(filteredList.get(i).toString());
                }
                System.out.println(filteredList.get(selection).name + " selected.\n");
                pcBuildComponentList.remove(this.MOBO);
                MOBO = (MOBOPart) filteredList.get(selection);
                pcBuildComponentList.add(filteredList.get(selection));
                printBuild();
                return true;
            case "case":
                filteredList.addAll(selectCase());
                if(filteredList.size() == 0) return false;
                if(selection == -1) {
                    Case = (CasePart) tempPartHolder;
                    tempPartHolder = null;
                    return false;
                }
                System.out.println("Filtered Case List:");
                for(int i = 0; i < filteredList.size(); i++) {
                    System.out.println(filteredList.get(i).toString());
                }
                System.out.println(filteredList.get(selection).name + " selected.\n");
                pcBuildComponentList.remove(this.Case);
                Case = (CasePart) filteredList.get(selection);
                pcBuildComponentList.add(filteredList.get(selection));
                printBuild();
                return true;
            default:
                System.out.println("Invalid part type.");
                return false;
        }
    }

    public void removeComponent(String partType){
        switch(partType.toLowerCase()) {
            case "cpu":
                if(CPU == null) return;
                pcBuildComponentList.remove(CPU);
                CPU = null;
                updateWattage();
                System.out.println("CPU removed.\n");
                printBuild();
                return;
            case "gpu":
                if(GPU == null) return;
                pcBuildComponentList.remove(GPU);
                GPU = null;
                updateWattage();
                System.out.println("GPU removed.\n");
                printBuild();
                return;
            case "psu":
                if(PSU == null) return;
                pcBuildComponentList.remove(PSU);
                PSU = null;
                updateWattage();
                System.out.println("PSU removed.\n");
                printBuild();
                return;
            case "mobo":
                if(MOBO == null) return;
                pcBuildComponentList.remove(MOBO);
                MOBO = null;
                updateWattage();
                System.out.println("MOBO removed.\n");
                printBuild();
                return;
            case "case":
                if(Case == null) return;
                pcBuildComponentList.remove(Case);
                CPU = null;
                updateWattage();
                System.out.println("Case removed.\n");
                printBuild();
                return;
            default:
                break;
        }
    }

    private void setBuildID() {
        this.buildID = Math.abs((this.owner.getUserID() + " " + this.buildName).hashCode());
    }

    public void setBuildID(int buildID) {
        this.buildID = buildID;
    }

    public int getBuildID() { return this.buildID;}

    private boolean sizeCheck(PCComponent part) {
        if(Case == null) return true;
        float partX = part.getDimensions()[0];
        float caseX = Case.getDimensions()[0];
        if(partX > caseX) return false;
        float partY = part.getDimensions()[1];
        float caseY = Case.getDimensions()[1];
        if(partY > caseY) return false;
        float partZ = part.getDimensions()[2];
        float caseZ = Case.getDimensions()[2];
        if(partZ > caseZ) return false;
        return true;
    }

    private boolean wattageCheck(PCComponent part) {
        if(!(part instanceof PCPoweredComponent)) return true;
        if(PSU == null) return true;
        PCPoweredComponent poweredPart = (PCPoweredComponent) part;
        updateWattage();
        if(PSU.getWattage() - totalWattage - poweredPart.getWattage() < 0) {
            return false;
        }
        return true;
    }

    private void updateWattage() {
        totalWattage = 0;
        for(int i = 0; i < pcBuildComponentList.size(); i++) {
            if(pcBuildComponentList.get(i) instanceof PCPoweredComponent) {
                PCPoweredComponent poweredPart = (PCPoweredComponent) pcBuildComponentList.get(i);
                totalWattage += poweredPart.getWattage();
            }
        }
    }

    private boolean caseCheck(CasePart LocalCase) {
        if(pcBuildComponentList.size() == 0) return true;
        for(int i = 0; i < pcBuildComponentList.size(); i++) {
            PCComponent part = pcBuildComponentList.get(i);
            float partX = part.getDimensions()[0];
            float caseX = LocalCase.getDimensions()[0];
            if (partX > caseX) return false;
            float partY = part.getDimensions()[1];
            float caseY = LocalCase.getDimensions()[1];
            if (partY > caseY) return false;
            float partZ = part.getDimensions()[2];
            float caseZ = LocalCase.getDimensions()[2];
            if (partZ > caseZ) return false;
        }
        return true;
    }

    private boolean PSUCheck(PSUPart part) {
        if(pcBuildComponentList.size() == 0) return true;
        updateWattage();
        if (part.getWattage() - totalWattage < 0) return false;
        return true;
    }

    public void writeList() throws IOException {
        if(owner == null || GPU == null || PSU == null || CPU == null || MOBO == null || Case == null){
            System.out.println(" - - WRITE: System is not complete! - - \n");
            return;
        }
        System.out.println(" - - WRITE: Write to Builds.txt succeeded! - - \n");
        FileWriter fileWriter = new FileWriter("data/Builds.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.println(owner.getUserID() + "\n" + GPU.getModelNumber() + "\n" + PSU.getModelNumber() + "\n"
                + CPU.getModelNumber() + "\n" + MOBO.getModelNumber() + "\n" + Case.getModelNumber() + "\n" + "---");
        printWriter.close();

    }

    public double price(){
        totalPrice = 0;
        int i = 0;
        if(pcBuildComponentList.size() == 0){
            return 0;
        }
        double CPUPrice = 0;
        double GPUPrice = 0;
        double MOBOPrice = 0;
        double CasePrice = 0;
        double PSUPrice = 0;
        if(CPU != null) CPUPrice = CPU.getPrice();
        if(GPU != null) GPUPrice = GPU.getPrice();
        if(MOBO != null) MOBOPrice = MOBO.getPrice();
        if(Case != null) CasePrice = Case.getPrice();
        if(PSU != null) PSUPrice = PSU.getPrice();
        return CPUPrice + GPUPrice + MOBOPrice + CasePrice + PSUPrice;
    }

    public void printBuild() {
        String CPUName = null;
        String GPUName = null;
        String MOBOName = null;
        String CaseName = null;
        String PSUName = null;
        if(CPU != null) CPUName = CPU.getName();
        if(GPU != null) GPUName = GPU.getName();
        if(MOBO != null) MOBOName = MOBO.getName();
        if(Case != null) CaseName = Case.getName();
        if(PSU != null) PSUName = PSU.getName();
        System.out.println("-----UPDATED BUILD-----\nCPU: " + CPUName + "\nGPU: " + GPUName + "\nMOBO: " + MOBOName + "\nCase: " + CaseName + "\nPSU: " + PSUName + "\nPrice: " + price() + "\n");
    }

    @Override
    public String toString() {
        return "User ID: "+ this.owner.getUserID() + "\nBuild ID: " + this.buildID +
                "\nBuild Name:" + this.buildName + "\nCPU: " + this.CPU.toString() + "\nGPU: "+
                this.GPU.toString() + "\nMOBO: " + this.MOBO.toString() + "\nCase: " + this.Case.toString() + "\nPSU: " +
                this.PSU.toString() + "\nRAM: " + this.RAM.toString();
    }
}