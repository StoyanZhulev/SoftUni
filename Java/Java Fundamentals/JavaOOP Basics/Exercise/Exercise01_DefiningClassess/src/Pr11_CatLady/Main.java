package Pr11_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> cats = new HashSet<>();

        String line = reader.readLine();
        while (!"End".equals(line)){
            cats.add(line);
            line = reader.readLine();
        }

        String searchedCat = reader.readLine();

        for (String cat : cats) {
            if(cat.contains(searchedCat)){
                System.out.println(cat);
                break;
            }
        }
    }
}
