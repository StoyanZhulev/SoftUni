import hardware.Hardware;
import software.Software;

import java.util.ArrayList;
import java.util.List;

public class TheSystem {
    private List<Hardware> powerHardwares;
    private List<Hardware> heavyHardwares;

    public TheSystem(){
        this.powerHardwares = new ArrayList<>();
        this.heavyHardwares = new ArrayList<>();
    }

    public List<Hardware> getPowerHardwares() {
        return powerHardwares;
    }

    public List<Hardware> getHeavyHardwares() {
        return heavyHardwares;
    }

    public void addHardware(Hardware hardware) {
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
        for (Hardware powerHardware : powerHardwares) {
            maxMemory += powerHardware.getMaximumMemory();
        }
        for (Hardware heavyHardware : heavyHardwares) {
            maxMemory += heavyHardware.getMaximumMemory();
        }

        return maxMemory;
    }
    private int getTotalCapacity(){
        int totalCapacity = 0;
        for (Hardware powerHardware : powerHardwares) {
            totalCapacity += powerHardware.getMaximumCapacity();
        }
        for (Hardware heavyHardware : heavyHardwares) {
            totalCapacity += heavyHardware.getMaximumCapacity();
        }

        return totalCapacity;
    }

    private int getMemoryInUse(){
        int memoryInUSe = 0;
        for (Hardware powerHardware : powerHardwares) {
            for (Software software : powerHardware.getSoftwareComponents()) {
                memoryInUSe += software.getMemoryConsumption();
            }
        }

        for (Hardware heavyHardware : heavyHardwares) {
            for (Software software : heavyHardware.getSoftwareComponents()) {
                memoryInUSe += software.getMemoryConsumption();
            }
        }

        return memoryInUSe;
    }
    private int getTakenCapacity(){
        int takenCapacity = 0;
        for (Hardware powerHardware : powerHardwares) {
            for (Software software : powerHardware.getSoftwareComponents()) {
                takenCapacity += software.getCapacityConsumption();
            }
        }

        for (Hardware heavyHardware : heavyHardwares) {
            for (Software software : heavyHardware.getSoftwareComponents()) {
                takenCapacity += software.getCapacityConsumption();
            }
        }

        return takenCapacity;
    }

    private int getSoftwareComponents(){
        int softwareComps = 0;
        for (Hardware powerHardware : powerHardwares) {
            softwareComps += powerHardware.getSoftwareComponents().size();
        }

        for (Hardware heavyHardware : heavyHardwares) {
            softwareComps += heavyHardware.getSoftwareComponents().size();

        }
        return softwareComps;
    }

    public void showStatistics(){
        StringBuilder output = new StringBuilder();
        output.append("System Analysis").append("\n")
                .append("Hardware Components: ").append(this.heavyHardwares.size() + this.powerHardwares.size()).append("\n")
                .append("Software Components: ").append(this.getSoftwareComponents()).append("\n")
                .append("Total Operational Memory: ").append(this.getMemoryInUse()).append(" / ").append(this.getTotalMemory()).append("\n")
                .append("Total Capacity Taken: ").append(getTakenCapacity()).append(" / ").append(getTotalCapacity());

        System.out.println(output);
    }

    public void splitSystem(){
        StringBuilder output = new StringBuilder();
        for (Hardware powerHardware : powerHardwares) {
            output.append("Hardware Component - ").append(powerHardware.getName()).append("\n")
                    .append("Express Software Components - ").append(powerHardware.getExpressSoftwareCount()).append("\n")
                    .append("Light Software Components - ").append(powerHardware.getLightSoftwareCount()).append("\n")
                    .append("Memory Usage: ").append(powerHardware.getMemoryUsage()).append(" / ").append(powerHardware.getMaximumMemory()).append("\n")
                    .append("Capacity Usage: ").append(powerHardware.getCapacityUsage()).append(" / ").append(powerHardware.getMaximumCapacity()).append("\n")
                    .append("Type: ").append(powerHardware.getClass().getSimpleName().substring(0, 5)).append("\n")
                    .append("Software Components: ");
            if(powerHardware.getSoftwareComponents().isEmpty()){
                output.append("None");
            }else{
                for (Software software : powerHardware.getSoftwareComponents()) {
                    output.append(software.toString()).append(", ");
                }
                output.delete(output.length() - 2, output.length());
                output.append("\n");
            }
        }
        for (Hardware heavyHardware : heavyHardwares) {
            output.append("Hardware Component - ").append(heavyHardware.getName()).append("\n")
                    .append("Express Software Components - ").append(heavyHardware.getExpressSoftwareCount()).append("\n")
                    .append("Light Software Components - ").append(heavyHardware.getLightSoftwareCount()).append("\n")
                    .append("Memory Usage: ").append(heavyHardware.getMemoryUsage()).append(" / ").append(heavyHardware.getMaximumMemory()).append("\n")
                    .append("Capacity Usage: ").append(heavyHardware.getCapacityUsage()).append(" / ").append(heavyHardware.getMaximumCapacity()).append("\n")
                    .append("Type: ").append(heavyHardware.getClass().getSimpleName().substring(0, 5)).append("\n")
                    .append("Software Components: ");
            if(heavyHardware.getSoftwareComponents().isEmpty()){
                output.append("None");
            }else{
                for (Software software : heavyHardware.getSoftwareComponents()) {
                    output.append(software.toString()).append(", ");
                }
                output.delete(output.length() - 2, output.length());
                output.append("\n");
            }
        }

        System.out.println(output);
    }
}
