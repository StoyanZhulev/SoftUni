package Lab09_StreaamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Pr03_FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.asList((reader.readLine().split(" ")));

        HashSet<Character> chars = new HashSet<>();

        Arrays.stream(reader.readLine().split(" "))
                .map(s -> s.charAt(0))
                .forEach(c -> chars.add(Character.toLowerCase(c)));

        Optional<String> firstName = names.stream()
                .filter(n -> chars.contains(n.toLowerCase().charAt(0)))
                .sorted()
                .findFirst();

        if(firstName.isPresent()){
            System.out.println(firstName.get());
        }else{
            System.out.println("No match");
        }
    }
}
