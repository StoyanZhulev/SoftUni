package SystemSplit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TheSystem system = new TheSystem();

        String command = reader.readLine();
        while (!"System Split".equals(command)){
            String[] commandArgs = command.trim().split("[(, )]");
            switch (commandArgs[0]){
                case "RegisterPowerHardware":
                    system.registerPowerHardware(commandArgs[1], Integer.parseInt(commandArgs[3]), Integer.parseInt(commandArgs[5]));
                    break;
                case "RegisterHeavyHardware":
                    system.registerHeavyHardware(commandArgs[1], Integer.parseInt(commandArgs[3]), Integer.parseInt(commandArgs[5]));
                    break;
                case "RegisterExpressSoftware":
                    system.registerExpressSoftware(commandArgs[1], commandArgs[3], Integer.parseInt(commandArgs[5]), Integer.parseInt(commandArgs[7]));
                    break;
                case "RegisterLightSoftware":
                    system.registerLightSoftware(commandArgs[1], commandArgs[3], Integer.parseInt(commandArgs[5]), Integer.parseInt(commandArgs[7]));
                    break;
                case "ReleaseSoftwareComponent":
                    system.releaseSoftwareComponent(commandArgs[1], commandArgs[3]);
                    break;
                case "Dump":
                    system.dump(commandArgs[1]);
                    break;
                case "Restore":
                    system.restore(commandArgs[1]);
                    break;
                case "Destroy":
                    system.destroy(commandArgs[1]);
                    break;
                case "DumpAnalyze":
                    system.dumpAnalyze();
                    break;
                case "Analyze":
                    system.analyze();
                    break;
            }

            command = reader.readLine();
        }

        system.split();
    }
}
