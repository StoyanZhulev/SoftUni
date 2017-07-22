package SystemSplit;

import SystemSplit.hardware.HardwareComponent;
import SystemSplit.hardware.HeavyHardwareComponent;
import SystemSplit.hardware.PowerHardwareComponent;
import SystemSplit.software.ExpressSoftwareComponent;
import SystemSplit.software.LightSoftwareComponent;
import SystemSplit.software.SoftwareComponent;

import java.util.ArrayList;
import java.util.List;

public class TheSystem {
    private List<HardwareComponent> powerHardwares;
    private List<HardwareComponent> heavyHardwares;

    private Dump dump = new Dump();

    public TheSystem(){
        this.powerHardwares = new ArrayList<>();
        this.heavyHardwares = new ArrayList<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        PowerHardwareComponent powerHardware = new PowerHardwareComponent(name, capacity, capacity);
        addHardware(powerHardware);
    }

    public void registerHeavyHardware(String name, int capacity, int memory){
        HeavyHardwareComponent heavyHardware = new HeavyHardwareComponent(name,capacity, memory);
        addHardware(heavyHardware);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory){
        ExpressSoftwareComponent expressSoftware = new ExpressSoftwareComponent(name,capacity, memory);

        HardwareComponent hardware = getHardware(hardwareComponentName);


        if(hardware != null){
            if(hardware.getCurrentCapacity() >= expressSoftware.getCapacityConsumption() && hardware.getCurrentMemory() >= expressSoftware.getMemoryConsumption()){
                hardware.registerSoftwareComponent(expressSoftware);
            }
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory){

        LightSoftwareComponent expressSoftware = new LightSoftwareComponent(name,capacity, memory);

        HardwareComponent hardware = getHardware(hardwareComponentName);

        if(hardware != null){
            if(hardware.getCurrentCapacity() >= expressSoftware.getCapacityConsumption() && hardware.getCurrentMemory() >= expressSoftware.getMemoryConsumption()){
                hardware.registerSoftwareComponent(expressSoftware);
            }
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {

        HardwareComponent hardware = getHardware(hardwareComponentName);
        if(hardware != null){
            for (SoftwareComponent software : hardware.getSoftwareComponents()) {
                if(software.getName().equals(softwareComponentName)){
                    hardware.removeSoftware(software);
                }
            }
        }
    }

    public void analyze() {
        StringBuilder output = new StringBuilder();
        output.append("System Analysis").append("\n")
                .append("Hardware Components: ").append(this.heavyHardwares.size() + this.powerHardwares.size()).append("\n")
                .append("Software Components: ").append(this.getSoftwareComponents()).append("\n")
                .append("Total Operational Memory: ").append(this.getMemoryInUse()).append(" / ").append(this.getTotalMemory()).append("\n")
                .append("Total Capacity Taken: ").append(getTakenCapacity()).append(" / ").append(getTotalCapacity());

        System.out.println(output);
    }

    public void split() {
        StringBuilder output = new StringBuilder();
        for (HardwareComponent powerHardware : powerHardwares) {
            output.append("Hardware Component - ").append(powerHardware.getName()).append("\n")
                    .append("Express Software Components - ").append(powerHardware.getExpressSoftwareCount()).append("\n")
                    .append("Light Software Components - ").append(powerHardware.getLightSoftwareCount()).append("\n")
                    .append("Memory Usage: ").append(powerHardware.getMemoryUsage()).append(" / ").append(powerHardware.getMaximumMemory()).append("\n")
                    .append("Capacity Usage: ").append(powerHardware.getCapacityUsage()).append(" / ").append(powerHardware.getMaximumCapacity()).append("\n")
                    .append("Type: ").append(powerHardware.getClass().getSimpleName().substring(0, 5)).append("\n")
                    .append("Software Components: ");
            if(powerHardware.getSoftwareComponents().isEmpty()){
                output.append("None\n");
            }else{
                for (SoftwareComponent software : powerHardware.getSoftwareComponents()) {
                    output.append(software.toString()).append(", ");
                }
                output.delete(output.length() - 2, output.length());
                output.append("\n");
            }
        }
        for (HardwareComponent heavyHardware : heavyHardwares) {
            output.append("Hardware Component - ").append(heavyHardware.getName()).append("\n")
                    .append("Express Software Components - ").append(heavyHardware.getExpressSoftwareCount()).append("\n")
                    .append("Light Software Components - ").append(heavyHardware.getLightSoftwareCount()).append("\n")
                    .append("Memory Usage: ").append(heavyHardware.getMemoryUsage()).append(" / ").append(heavyHardware.getMaximumMemory()).append("\n")
                    .append("Capacity Usage: ").append(heavyHardware.getCapacityUsage()).append(" / ").append(heavyHardware.getMaximumCapacity()).append("\n")
                    .append("Type: ").append(heavyHardware.getClass().getSimpleName().substring(0, 5)).append("\n")
                    .append("Software Components: ");
            if(heavyHardware.getSoftwareComponents().isEmpty()){
                output.append("None\n");
            }else{
                for (SoftwareComponent software : heavyHardware.getSoftwareComponents()) {
                    output.append(software.toString()).append(", ");
                }
                output.delete(output.length() - 2, output.length());
                output.append("\n");
            }
        }

        System.out.println(output);
    }

    public void dump(String hardwareComponent){
        HardwareComponent hardware = getHardware(hardwareComponent);

        if(hardware != null){
            String type = hardware.getType();
            switch (type){
                case "heavyHardware":
                    this.heavyHardwares.remove(hardware);
                    break;
                case "powerHardware":
                    this.powerHardwares.remove(hardware);
                    break;
            }
        }

        dump.addDumpedHardware(hardware);
    }

    public  void restore(String hardwareName){
        HardwareComponent hardware = dump.restoreHardware(hardwareName);
        if(hardware != null){
            addHardware(hardware);
        }

    }

    public void destroy(String hardwareName){
        dump.destroy(hardwareName);
    }

    public void dumpAnalyze(){
        dump.dumpAnalisys();
    }

    private void addHardware(HardwareComponent hardware) {
        String hardwareType = hardware.getType();
        switch (hardwareType){
            case "powerHardware":
                this.powerHardwares.add(hardware);
                break;
            case "heavyHardware":
                this.heavyHardwares.add(hardware);
                break;
        }
    }

    private int getTotalMemory(){
        int maxMemory = 0;
        for (HardwareComponent powerHardware : powerHardwares) {
            maxMemory += powerHardware.getMaximumMemory();
        }
        for (HardwareComponent heavyHardware : heavyHardwares) {
            maxMemory += heavyHardware.getMaximumMemory();
        }

        return maxMemory;
    }
    private int getTotalCapacity(){
        int totalCapacity = 0;
        for (HardwareComponent powerHardware : powerHardwares) {
            totalCapacity += powerHardware.getMaximumCapacity();
        }
        for (HardwareComponent heavyHardware : heavyHardwares) {
            totalCapacity += heavyHardware.getMaximumCapacity();
        }

        return totalCapacity;
    }

    private int getMemoryInUse(){
        int memoryInUSe = 0;
        for (HardwareComponent powerHardware : powerHardwares) {
            for (SoftwareComponent software : powerHardware.getSoftwareComponents()) {
                memoryInUSe += software.getMemoryConsumption();
            }
        }

        for (HardwareComponent heavyHardware : heavyHardwares) {
            for (SoftwareComponent software : heavyHardware.getSoftwareComponents()) {
                memoryInUSe += software.getMemoryConsumption();
            }
        }

        return memoryInUSe;
    }
    private int getTakenCapacity(){
        int takenCapacity = 0;
        for (HardwareComponent powerHardware : powerHardwares) {
            for (SoftwareComponent software : powerHardware.getSoftwareComponents()) {
                takenCapacity += software.getCapacityConsumption();
            }
        }

        for (HardwareComponent heavyHardware : heavyHardwares) {
            for (SoftwareComponent software : heavyHardware.getSoftwareComponents()) {
                takenCapacity += software.getCapacityConsumption();
            }
        }

        return takenCapacity;
    }

    private int getSoftwareComponents(){
        int softwareComps = 0;
        for (HardwareComponent powerHardware : powerHardwares) {
            softwareComps += powerHardware.getSoftwareComponents().size();
        }

        for (HardwareComponent heavyHardware : heavyHardwares) {
            softwareComps += heavyHardware.getSoftwareComponents().size();

        }
        return softwareComps;
    }

    private HardwareComponent getHardware(String hardwareName){
        HardwareComponent hardware = null;
        for (HardwareComponent hard : this.heavyHardwares) {
            if(hardwareName.equals(hard.getName())){
                hardware = hard;
            }
        }
        if(hardware == null){
            for (HardwareComponent hard : this.powerHardwares) {
                if(hardwareName.equals(hard.getName())){
                    hardware = hard;
                }
            }
        }

        return hardware;
    }
}
