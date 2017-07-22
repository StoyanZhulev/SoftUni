package Pr02_Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        ListyIterator listyIterator;
        if(command.length() > 7){
            String[] strings = command.substring(6).trim().split(" ");
            listyIterator = new ListyIterator(strings);

        }else{
            listyIterator = new ListyIterator();
        }

        command = reader.readLine();
        while (!"END".equals(command)){
            switch (command){
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try{
                        listyIterator.print();
                    }catch (IllegalArgumentException iae ){
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                default:
                    break;

            }

            command = reader.readLine();
        }

    }
}
