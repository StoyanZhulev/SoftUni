import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;

public class Pr01_CommandInterpreter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = (reader.readLine().split(" "));
        String[] command = reader.readLine().split(" ");

        int start = 0;
        int count = 0;
        ArrayList<String> currList = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        for (String s : input) {
            strings.add(s);
        }

        while(!"end".equals(command[0])){
            switch (command[0]){
                case "reverse":
                    start = Integer.parseInt(command[2]);
                    count = Integer.parseInt(command[4]);

                    Collections.reverse(currList);
                   currList.addAll(0, strings.subList(0, start));
                    strings = currList;


            }
        }

        System.out.println(input);
    }
}
