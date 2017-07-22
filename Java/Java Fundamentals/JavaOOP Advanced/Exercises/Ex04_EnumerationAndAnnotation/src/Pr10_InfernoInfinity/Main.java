package Pr10_InfernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        LinkedHashMap<String, Weapon> weapons = new LinkedHashMap<>();

        while (!"END".equals(command)) {
            String[] cmdArgs = command.split(";");
            String type = cmdArgs[0];
            switch (type) {
                case "Create":
                    Weapon weapon = new Weapon(cmdArgs[2], WeaponType.valueOf(cmdArgs[1].toUpperCase()));
                    weapons.put(cmdArgs[2], weapon);
                    break;
                case "Add":
                    try {
                        weapons.get(cmdArgs[1]).addGem(Integer.parseInt(cmdArgs[2]), GemType.valueOf(cmdArgs[3].toUpperCase()));
                    } catch (IllegalArgumentException ignored) {}
                    break;
                case "Remove":
                    try {
                        weapons.get(cmdArgs[1]).removeGem(Integer.parseInt(cmdArgs[2]));
                    } catch (IllegalArgumentException ignored) {}
                    break;
                case "Print":
                    System.out.println(weapons.get(cmdArgs[1]));
                    break;
                case "Compare":
                    Weapon firstWeapon = weapons.get(cmdArgs[1]);
                    Weapon secondWeapon = weapons.get(cmdArgs[2]);

                    if(firstWeapon.compareTo(secondWeapon) >= 0){
                        System.out.println(firstWeapon.print());
                    }else{
                        System.out.println(secondWeapon.print());
                    }
                    break;
                default:
                    executeAnnotationCommand(type);
                    break;
            }

            command = reader.readLine();
        }

    }

    private static void executeAnnotationCommand(String type) {
        Class<?> weaponClass = Weapon.class;
        ClassInformation classInformation = weaponClass.getAnnotation(ClassInformation.class);
        switch (type){
            case "Author":
                System.out.println("Author: " + classInformation.author());
                break;
            case "Revision":
                System.out.println("Revision: "+ classInformation.revision());
                break;
            case "Description":
                System.out.println("Class description: " + classInformation.description());
                break;
            case "Reviewers":
                System.out.println("Reviewers: " + String.join(", ",classInformation.reviewers()));
        }
    }
}
