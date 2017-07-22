package Pr09_TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] trLights = reader.readLine().split(" ");


        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String signal : trLights) {
            TrafficLight tl = new TrafficLight(signal);
            trafficLights.add(tl);
        }

        int lightUpdates = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lightUpdates; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                result.append(trafficLight.updateSignal()).append(" ");
            }
            result.append(System.lineSeparator());
        }

        System.out.println(result.toString().trim());
    }
}
