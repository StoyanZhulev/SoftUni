package Pr01_HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {
        Class cl = RichSoilLand.class;

        Field[] fields = cl.getDeclaredFields();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        while (!"HARVEST".equals(command)) {
            switch (command) {
                case "private":
                    for (Field field : fields) {
                        if (Modifier.isPrivate(field.getModifiers())) {
                            System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                        }
                    }
                    break;
                case "protected":
                    for (Field field : fields) {
                        if (Modifier.isProtected(field.getModifiers())) {
                            System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                        }
                    }
                    break;
                case "public":
                    for (Field field : fields) {
                        if (Modifier.isPublic(field.getModifiers())) {
                            System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                        }
                    }
                    break;
                case "all":
                    for (Field field : fields) {
                        System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));

                    }
                    break;
            }

            command = reader.readLine();
        }
    }

}
