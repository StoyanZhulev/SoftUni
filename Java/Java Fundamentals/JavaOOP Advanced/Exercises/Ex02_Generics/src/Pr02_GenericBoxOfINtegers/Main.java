package Pr02_GenericBoxOfINtegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, IOException {
        Box<Integer>box  = new Box<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            int  num = Integer.parseInt(reader.readLine());

            String out = box.print(num);
            System.out.println(out.substring(6));
        }
    }
}
