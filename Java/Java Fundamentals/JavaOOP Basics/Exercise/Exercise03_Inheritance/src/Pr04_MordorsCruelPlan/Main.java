package Pr04_MordorsCruelPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] foodLine = reader.readLine().split(" ");
        Gandalf gandalf = new Gandalf();
        gandalf.setHappiness(foodLine);
        System.out.println(gandalf.getHappiness());
        System.out.println(gandalf.getMood());
    }
}
