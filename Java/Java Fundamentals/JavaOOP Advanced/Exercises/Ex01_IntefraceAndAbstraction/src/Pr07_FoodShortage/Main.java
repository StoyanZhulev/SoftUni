package Pr07_FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,BaseEntity> entities = new HashMap<>();


        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");

            switch (line.length){
                case 4:
                    BaseEntity cit = new Citizen(line[0], Integer.parseInt(line[1]), line[2], line[3]);
                    entities.put(cit.getName(),cit);
                    break;
                case 3:
                    BaseEntity reb = new Rebel(line[0], Integer.parseInt(line[1]), line[2]);
                    entities.put(reb.getName(),reb);
                    break;
                default:
                    break;
            }
        }

        String name = reader.readLine();

        while (!"End".equals(name)){
            if(entities.containsKey(name)){
                entities.get(name).buyFood();
            }
            name = reader.readLine();
        }
        int food = 0;

        for (BaseEntity baseEntity : entities.values()) {
            food += baseEntity.getFood();
        }

        System.out.println(food);

//        detained.addAll(entities.stream().filter(entity -> entity.getBirthDay().endsWith(endNum)).map(BaseEntity::getBirthDay).collect(Collectors.toList()));
//        detained.forEach(System.out::println);
    }
}
