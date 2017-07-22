package Ex04_SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr07_FixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();


        String name = console.nextLine();

        while(!name.equals("stop")){
            String email = console.nextLine();


            String lastSymbols = email.substring(email.length() - 3);

            if(!lastSymbols.equals(".uk") && !lastSymbols.equals(".us")){
                emails.put(name, email);
            }

            name = console.nextLine();
        }

        for (Map.Entry entry : emails.entrySet()){
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
