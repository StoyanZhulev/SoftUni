import hardware.Hardware;
import hardware.HeavyHardware;
import hardware.PowerHardware;
import software.ExpressSoftware;
import software.LightSoftware;
import software.Software;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static TheSystem SYSTEM = new TheSystem();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        while (!"System Split".equals(command)){
            String[] commandArgs = command.trim().split("[(, )]");
            switch (commandArgs[0]){
                case "RegisterPowerHardware":
                    execRegisterPowerHardwareCommand(commandArgs);
                    break;
                case "RegisterHeavyHardware":
                    execRegisterHeavyHardwareCommand(commandArgs);
                    break;
                case "RegisterExpressSoftware":
                    execRegisterExpressSoftware(commandArgs);
                    break;
                case "RegisterLightSoftware":
                    execRegisterLightSoftwareCommand(commandArgs);
                    break;
                case "ReleaseSoftwareComponent":
                    execReleaseSoftwareComponentCommand(commandArgs);
                    break;
                case "Analyze":
                    SYSTEM.showStatistics();
            }

            command = reader.readLine();
        }

        SYSTEM.splitSystem();
    }


    private static void execReleaseSoftwareComponentCommand(String[] commandArgs) {
        String hardwareName = commandArgs[1];
        String softwareName = commandArgs[3];
        
        Hardware hardware = getHardware(hardwareName);
        if(hardware != null){
            for (Software software : hardware.getSoftwareComponents()) {
                if(software.getName().equals(softwareName)){
                    hardware.removeSoftware(software);
                }
            }
        }
        
    }

    private static void execRegisterLightSoftwareCommand(String[] commandArgs) {
        String hardwareName = commandArgs[1];
        String softwareName = commandArgs[3];
        int capacity = Integer.parseInt(commandArgs[5]);
        int memory = Integer.parseInt(commandArgs[7]);

        LightSoftware expressSoftware = new LightSoftware(softwareName,"lightSoftware", capacity, memory);

        Hardware hardware = getHardware(hardwareName);

        if(hardware != null){
            if(hardware.getCurrentCapacity() >= expressSoftware.getCapacityConsumption() && hardware.getCurrentMemory() >= expressSoftware.getMemoryConsumption()){
                hardware.addSoftware(expressSoftware);
            }
        }
    }

    private static void execRegisterExpressSoftware(String[] commandArgs) {
        String hardwareName = commandArgs[1];
        String softwareName = commandArgs[3];
        int capacity = Integer.parseInt(commandArgs[5]);
        int memory = Integer.parseInt(commandArgs[7]);

        ExpressSoftware expressSoftware = new ExpressSoftware(softwareName,"expressSoftware", capacity, memory);
        
        Hardware hardware = getHardware(hardwareName);
        
        
        if(hardware != null){
            if(hardware.getCurrentCapacity() >= expressSoftware.getCapacityConsumption() && hardware.getCurrentMemory() >= expressSoftware.getMemoryConsumption()){
                hardware.addSoftware(expressSoftware);
            }
        }
    }

    private static void execRegisterHeavyHardwareCommand(String[] commandArgs) {
        String name = commandArgs[1];
        int maxCapacity = Integer.parseInt(commandArgs[3]);
        int maxMemory = Integer.parseInt(commandArgs[5]);
        HeavyHardware heavyHardware = new HeavyHardware(name,"heavyHardware", maxCapacity, maxMemory);
        SYSTEM.addHardware(heavyHardware);
    }

    private static void execRegisterPowerHardwareCommand(String[] commandArgs) {
        String name = commandArgs[1];
        int maxCapacity = Integer.parseInt(commandArgs[3]);
        int maxMemory = Integer.parseInt(commandArgs[5]);
        PowerHardware powerHardware = new PowerHardware(name, "powerHardware", maxCapacity, maxMemory);
        SYSTEM.addHardware(powerHardware);
    }
    
    
    private static Hardware getHardware(String hardwareName){
        Hardware hardware = null;
        for (Hardware hard : SYSTEM.getHeavyHardwares()) {
            if(hardwareName.equals(hard.getName())){
                hardware = hard;
            }
        }
        if(hardware == null){
            for (Hardware hard : SYSTEM.getPowerHardwares()) {
                if(hardwareName.equals(hard.getName())){
                    hardware = hard;
                }
            }
        }
        
        return hardware;
    }
}
