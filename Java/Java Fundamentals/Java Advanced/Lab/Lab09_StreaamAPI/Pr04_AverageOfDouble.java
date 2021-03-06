package Lab09_StreaamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Pr04_AverageOfDouble {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> tokens = Arrays.asList(reader.readLine().split(" "));

        DoubleStream stream = tokens.stream()
                //.peek(x -> System.out.println(x)) -->only for debugging
                .filter(x -> !x.isEmpty())
                .mapToDouble(x -> Double.valueOf(x));
        OptionalDouble result = stream.average();

        if(result.isPresent()){
            System.out.printf("%.2f", result.getAsDouble());
        }else{
            System.out.println("No match");
        }
    }
}
