package Pr10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String line = reader.readLine();
            String[] lArgs = line.split(" ");
            if(lArgs.length == 3){
                String name = lArgs[0] + " "+ lArgs[1];
                String adress = lArgs[2];
                Tuple<String, String> tuple = new Tuple<>(name, adress);

                System.out.println(tuple.getItem1() + " -> " + tuple.getItem2());
            }else{
                try{
                    int item1 = Integer.parseInt(lArgs[0]);
                    double item2 = Double.parseDouble(lArgs[1]);
                    Tuple<Integer, Double> tuple = new Tuple<>(item1, item2);
                    System.out.println(tuple.getItem1() + " -> " + tuple.getItem2());
                }catch (NumberFormatException nfe){
                    String item1 = lArgs[0];
                    int item2 = Integer.parseInt(lArgs[1]);
                    Tuple<String, Integer> tuple = new Tuple<>(item1, item2);
                    System.out.println(tuple.getItem1() + " -> " + tuple.getItem2());
                }
            }

        }
    }
}
