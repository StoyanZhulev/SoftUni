package Pr03_Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();

        Car ferrari = new Ferrarri(name);

        System.out.println(ferrari.getModel()
                + "/"
                + ferrari.brakes()
                + "/"
                + ferrari.gasPedal()
                + "/"
                + ferrari.getName());
    }
}
