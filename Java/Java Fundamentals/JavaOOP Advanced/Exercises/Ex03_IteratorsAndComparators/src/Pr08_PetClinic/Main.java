package Pr08_PetClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, Clinic> clinics = new HashMap<>();
    private static final Map<String, PetImpl> pets = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] cmdArgs = reader.readLine().split(" ");
            String command = cmdArgs[0];

            switch (command) {
                case "Create":
                    executeCreateCommand(cmdArgs);
                    break;
                case "Add":
                    System.out.println(executeAddCommand(cmdArgs));
                    break;
                case "Release":
                    System.out.println(executeReleaseCommand(cmdArgs));
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(cmdArgs[1]).hasEmptyRooms());
                    break;
                case "Print":
                    System.out.println(executePrintCommand(cmdArgs));
                    break;
                default:
                    break;
            }
        }
    }

    private static String executePrintCommand(String[] cmdArgs) {
        String clinicName = cmdArgs[1];
        if (cmdArgs.length > 2) {
            int room = Integer.parseInt(cmdArgs[2]);
            return clinics.get(clinicName).print(room);
        }

        return clinics.get(clinicName).print();
    }

    private static boolean executeReleaseCommand(String[] cmdArgs) {
        return clinics.get(cmdArgs[1]).release();
    }

    private static boolean executeAddCommand(String[] cmdArgs) {
        String petName = cmdArgs[1];
        String clinicName = cmdArgs[2];

        return clinics.get(clinicName).addPet(pets.get(petName));
    }

    private static void executeCreateCommand(String[] cmdArgs) {
        switch (cmdArgs[1]) {
            case "Pet":
                PetImpl pet = PetImpl.createPet(cmdArgs[2], Integer.parseInt(cmdArgs[3]), cmdArgs[4]);
                pets.put(cmdArgs[2], pet);
                break;
            case "Clinic":
                try{
                    Clinic clinic = ClinicImpl.createClinic(cmdArgs[2], Integer.parseInt(cmdArgs[3]));
                    clinics.put(cmdArgs[2], clinic);
                }catch (IllegalArgumentException iae){
                    System.out.println(iae.getMessage());
                }
                break;
            default:
                break;
        }
    }
}
