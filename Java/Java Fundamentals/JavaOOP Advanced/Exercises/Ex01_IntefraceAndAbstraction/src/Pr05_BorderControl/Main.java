package Pr05_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> entities = new ArrayList<>();
        List<String> detained = new ArrayList<>();

        String line = reader.readLine();

        while (!"End".equals(line)) {
            String[] lineArgs = line.split(" ");
           switch (lineArgs.length){
               case 3:
                   Identifiable citizen = new Citizen(lineArgs[0], Integer.parseInt(lineArgs[1]), lineArgs[2]);
                   entities.add(citizen);
                   break;
               case 2:
                   Identifiable robot = new Robot(lineArgs[0], lineArgs[1]);
                   entities.add(robot);
                   break;
           }

            line = reader.readLine();
        }

        String endNum = reader.readLine();

        for (Identifiable entity : entities) {
            if(entity.getId().endsWith(endNum)){
                detained.add(entity.getId());
            }
        }

        for (String s : detained) {
            System.out.println(s);
        }
    }
}
