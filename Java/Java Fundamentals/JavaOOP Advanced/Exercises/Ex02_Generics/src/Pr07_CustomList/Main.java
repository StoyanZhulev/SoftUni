package Pr07_CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CommandInterpreter<String> custom = new CommandInterpreter<>();

        String command = reader.readLine();

        while (!"END".equals(command)){
            String[] cmdArgs = command.split(" ");
            String type = cmdArgs[0];

            switch (type){
                case "Add":
                    custom.add(cmdArgs[0]);
                    break;
                case "Remove":
                    custom.remove(Integer.parseInt(cmdArgs[1]));
                    break;
                case "Contains":
                    System.out.println(custom.contains(cmdArgs[1]));
                    break;
                case "Swap":
                    custom.swap(Integer.parseInt(cmdArgs[1]), Integer.parseInt(cmdArgs[2]));
                    break;
                case "Greater":
                    System.out.println(custom.countGreaterThat(cmdArgs[1]));
                    break;
                case "Max":
                    System.out.println(custom.getMax());
                    break;
                case "Min":
                    System.out.println(custom.getMin());
                    break;
                case "Print":
                    System.out.println(custom.print());
                    break;
                case "Sort":
                    custom.sort();
                default:
                    break;
            }

            command = reader.readLine();
        }


    }
}
