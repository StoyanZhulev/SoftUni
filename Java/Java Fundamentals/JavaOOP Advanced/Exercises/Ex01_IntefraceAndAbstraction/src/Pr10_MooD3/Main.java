package Pr10_MooD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(" \\| ");
        if(line[1].equals("Demon")){
            Entity demon = new Demon(line[0], Integer.parseInt(line[3]),  Double.parseDouble(line[2]));
            System.out.println(demon.toString());
        }else if(line[1].equals("Archangel")){
            Entity archangel = new Archangel(line[0], Integer.parseInt(line[3]), Integer.parseInt(line[2]));
            System.out.println(archangel.toString());
        }
    }
}
