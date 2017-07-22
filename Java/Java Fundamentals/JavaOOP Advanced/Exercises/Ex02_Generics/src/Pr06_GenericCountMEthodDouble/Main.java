package Pr06_GenericCountMEthodDouble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Double> list= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Double.valueOf(reader.readLine()));
        }

        System.out.println(Count.count(list, Double.parseDouble(reader.readLine())));
    }
}
