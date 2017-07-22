package SystemSplit;

import SystemSplit.hardware.HardwareComponent;
import SystemSplit.software.SoftwareComponent;

import java.util.ArrayList;
import java.util.List;

public class Dump {
    private List<HardwareComponent> powerHardwareCOmponents;
    private List<HardwareComponent> heavyHardwareComponents;

    public Dump(){
        this.powerHardwareCOmponents = new ArrayList<>();
        this.heavyHardwareComponents = new ArrayList<>();
    }

    public int getPowerHardwaresCount(){
        return this.powerHardwareCOmponents.size();
    }

    public int getHeavyHardwaresCount(){
        return this.heavyHardwareComponents.size();
    }

    public int getExpressSoftwaresCount(){
        int count = 0;
        for (HardwareComponent hard : powerHardwareCOmponents) {
            for (SoftwareComponent softwareComponent : hard.getSoftwareComponents()) {
                if(softwareComponent.getType().equals("expressSoftware")){
                    count++;
                }
            }
        }
        for (HardwareComponent hard : heavyHardwareComponents) {
            for (SoftwareComponent softwareComponent : hard.getSoftwareComponents()) {
                if(softwareComponent.getType().equals("expressSoftware")){
                    count++;
                }
            }
        }
        return count;
    }

    public int getLightSoftwaresCount(){
        int count = 0;
        for (HardwareComponent hard : powerHardwareCOmponents) {
            for (SoftwareComponent softwareComponent : hard.getSoftwareComponents()) {
                if(softwareComponent.getType().equals("lightSoftware")){
                    count++;
                }
            }
        }
        for (HardwareComponent hard : heavyHardwareComponents) {
            for (SoftwareComponent softwareComponent : hard.getSoftwareComponents()) {
                if(softwareComponent.getType().equals("lightSoftware")){
                    count++;
                }
            }
        }
        return count;
    }

    public void dumpAnalisys(){
        StringBuilder sb = new StringBuilder();
        sb.append("Dump Analysis\n");
        sb.append("Power Hardware Components: ").append(getPowerHardwaresCount()).append("\n");
        sb.append("Heavy Hardware Components: ").append(getHeavyHardwaresCount()).append("\n");
        sb.append("Express Software Components: ").append(getExpressSoftwaresCount()).append("\n");
        sb.append("Light Software Components: ").append(getLightSoftwaresCount()).append("\n");
        sb.append("Total Dumped Memory: ").append(getTotalDumpedMemory()).append("\n");
        sb.append("Total Dumped Capacity: ").append(getTotalDumpedCapacity());

        System.out.println(sb);
    }

    public int getTotalDumpedMemory(){
        int maxMemory = 0;
        for (HardwareComponent powerHardware : this.powerHardwareCOmponents) {
            for (SoftwareComponent softwareComponent : powerHardware.getSoftwareComponents()) {
                maxMemory += softwareComponent.getMemoryConsumption();
            }
        }
        for (HardwareComponent heavyHardware : this.heavyHardwareComponents) {
            for (SoftwareComponent softwareComponent : heavyHardware.getSoftwareComponents()) {
                maxMemory += softwareComponent.getMemoryConsumption();
            }
        }

        return maxMemory;
    }

    private int getTotalDumpedCapacity(){
        int totalCapacity = 0;
        for (HardwareComponent powerHardware : this.powerHardwareCOmponents) {
            for (SoftwareComponent softwareComponent : powerHardware.getSoftwareComponents()) {
                totalCapacity += softwareComponent.getCapacityConsumption();
            }
        }
        for (HardwareComponent heavyHardware : this.heavyHardwareComponents) {
            for (SoftwareComponent softwareComponent : heavyHardware.getSoftwareComponents()) {
                totalCapacity += softwareComponent.getCapacityConsumption();
            }
        }

        return totalCapacity;
    }

    public void addDumpedHardware(HardwareComponent hardwareComponent){
        String type = hardwareComponent.getType();
        switch (type){
            case "heavyHardware":
                this.heavyHardwareComponents.add(hardwareComponent);
                break;
            case "powerHardware":
                this.powerHardwareCOmponents.add(hardwareComponent);
                break;
        }
    }

    public void destroy(String hardwareName){
        HardwareComponent hardware = null;

        for (HardwareComponent hard : powerHardwareCOmponents) {
            if(hard.getName().equals(hardwareName)){
                hardware = hard;
            }
        }

        if(hardware == null){
            for (HardwareComponent hard : heavyHardwareComponents) {
                if(hard.getName().equals(hardwareName)){
                    hardware = hard;
                }
            }
        }

        if(hardware != null){
            String hardwareType = hardware.getType();
            switch (hardwareType){
                case "heavyHardware":
                    this.heavyHardwareComponents.remove(hardware);
                    break;
                case "powerHardware":
                    this.powerHardwareCOmponents.remove(hardware);
                    break;
            }
        }
    }

    public HardwareComponent restoreHardware(String hardwareName){
        HardwareComponent hardware = null;

        for (HardwareComponent hard : powerHardwareCOmponents) {
            if(hard.getName().equals(hardwareName)){
                hardware = hard;
            }
        }

        if(hardware == null){
            for (HardwareComponent hard : heavyHardwareComponents) {
                if(hard.getName().equals(hardwareName)){
                    hardware = hard;
                }
            }
        }

        if(hardware != null){
            String hardwareType = hardware.getType();
            switch (hardwareType){
                case "heavyHardware":
                    this.heavyHardwareComponents.remove(hardware);
                    break;
                case "powerHardware":
                    this.powerHardwareCOmponents.remove(hardware);
                    break;
            }
        }

        return hardware;
    }
}
