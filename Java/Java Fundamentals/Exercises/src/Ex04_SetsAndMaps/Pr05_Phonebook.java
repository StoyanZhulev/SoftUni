package Ex04_SetsAndMaps;

import java.util.HashMap;
import java.util.Scanner;

public class Pr05_Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        HashMap<String, String> phonebook = new HashMap<>();

        String[] command = console.nextLine().split("-");

        while(!command[0].equals("search")){
            phonebook.put(command[0], command[1]);

            command = console.nextLine().split("-");
        }


        while(!command[0].equals("stop")){
            command = console.nextLine().split("-");
            if(command[0].equals("stop")){
                return;

            }
            if(phonebook.containsKey(command[0])){
                System.out.println(command[0] + " -> " + phonebook.get(command[0]));

            }else {
                System.out.println("Contact "+command[0]+" does not exist.");
            }
        }

    }
}
