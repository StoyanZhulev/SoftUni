package Pr02_BlackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class blackboxClass = BlackBoxInt.class;
        Constructor con = blackboxClass.getDeclaredConstructor();
        con.setAccessible(true);
        Object box = con.newInstance();
        Method[] methods = blackboxClass.getDeclaredMethods();

        String command = reader.readLine();

        while (!"END".equals(command)) {
            String[] cmdArgs = command.split("_");

            executeMethod(blackboxClass, box, methods, cmdArgs);

            command = reader.readLine();
        }

    }


    private static void executeMethod(Class blackboxClass, Object box, Method[] methods, String[] cmdArgs) throws IllegalAccessException, InvocationTargetException {
        for (Method method : methods) {
            if (method.getName().equals(cmdArgs[0])) {
                method.setAccessible(true);
                method.invoke(box, Integer.parseInt(cmdArgs[1]));
                Field field = blackboxClass.getDeclaredFields()[0];
                field.setAccessible(true);
                System.out.println(field.get(box));
            }
        }
    }
}
