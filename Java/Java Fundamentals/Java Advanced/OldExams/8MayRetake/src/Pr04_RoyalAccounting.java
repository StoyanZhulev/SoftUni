import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr04_RoyalAccounting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^([A-Za-z]+);(-*[0-9]+);(-*[0-9]+\\.*[0-9]*);([A-Za-z]+)$");

        TreeMap<String, TreeMap<String, ArrayList<Double>>> teams = new TreeMap<>();
        TreeMap<String, Double> teamsCash = new TreeMap<>();
        String input = reader.readLine();
        HashSet<String> names = new HashSet<>();
        while (!"Pishi kuf i da si hodim".equals(input)){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find(0)){
                String employeeName = matcher.group(1);
                Double workHoursPerDay = Double.parseDouble(matcher.group(2));
                Double dailyPayment = new Double(matcher.group(3));
                String team = matcher.group(4);
                Double monthlyPayment = (dailyPayment* (workHoursPerDay)) / (24.0 * 30.0);
                Double dailyTotal = (dailyPayment * (workHoursPerDay)) / 24.0;


                if(!names.contains(employeeName)){
                    teams.putIfAbsent(team, new TreeMap<>());
                    teamsCash.putIfAbsent(team, 0D);

                    if(!teams.get(team).containsKey(employeeName)){
                        teams.get(team).put(employeeName, new ArrayList<>());

                        teams.get(team).get(employeeName).add(workHoursPerDay);
                        teams.get(team).get(employeeName).add(dailyTotal);

                        teamsCash.put(team, teamsCash.get(team) + monthlyPayment);
                    }

                }
                names.add(employeeName);
            }

            input = reader.readLine();
        }

        teams.entrySet().stream()
                .sorted((v1, v2) -> teamsCash.get(v2.getKey()).compareTo(teamsCash.get(v1.getKey())))
                .forEach(team -> {
                    System.out.println("Team - "+ team.getKey());
                    team.getValue().entrySet().stream()
                            .sorted((p1, p2) -> {
                                double firstCash = p1.getValue().get(0);
                                double secondCash = p2.getValue().get(0);

                                if(firstCash == secondCash){
                                    return Double.compare(p2.getValue().get(1),(p1.getValue().get(1)));
                                }else{
                                    return Double.compare(secondCash, firstCash);
                                }
                            })
                            .forEach(e -> {
                                System.out.printf("$$$%s - %.0f - %.6f%n", e.getKey(), e.getValue().get(0), e.getValue().get(1));
                            });

                });
    }
}
