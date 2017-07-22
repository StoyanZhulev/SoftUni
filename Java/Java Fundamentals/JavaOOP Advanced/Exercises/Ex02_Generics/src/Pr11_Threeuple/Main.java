package Pr11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] line1 = reader.readLine().split(" ");
        String item1 = line1[0] + " " + line1[1];
        String item2 = line1[2];
        String item3 = line1[3];
        Threeuple<String, String, String> tu1 = new Threeuple<>(item1, item2, item3);
        System.out.println(tu1.toString());

        String[] line2 = reader.readLine().split(" ");
        String it1 = line2[0];
        int it2 = Integer.parseInt(line2[1]);
        boolean isDrunk = false;
        if (line2[2].equals("drunk")) {
            isDrunk = true;
        } else if (line2[2].equals("not")) {
            isDrunk = false;
        }
        Threeuple<String, Integer, Boolean> tu2 = new Threeuple<>(it1, it2, isDrunk);
        System.out.println(tu2.toString());


        String[] line3 = reader.readLine().split(" ");
        String i1 = line3[0];
        double i2 = Double.parseDouble(line3[1]);
        String i3 = line3[2];
        Threeuple<String, Double, String> tu3 = new Threeuple<>(i1, i2, i3);
        System.out.println(tu3.toString());

    }
}

