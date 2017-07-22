import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr04_AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "^Grow <([A-Z][a-z]+)> <([A-Za-z0-9]+)> ([0-9]+)$";
        Pattern pattern = Pattern.compile(regex);

        TreeMap<String, TreeMap<String, Long>> roses = new TreeMap<>();
        TreeMap<String, Long> regionRoses = new TreeMap<>();

        while(true){
            String input = reader.readLine();
            if("Icarus, Ignite!".equals(input)){
                break;
            }

            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                String region = matcher.group(1);
                String rose = matcher.group(2);
                long quantity = Long.parseLong(matcher.group(3));

                if(!roses.containsKey(region)){
                    roses.put(region, new TreeMap<>());
                    roses.get(region).put(rose, quantity);
                    regionRoses.put(region, quantity);
                }else{
                    if(!roses.get(region).containsKey(rose)){
                        roses.get(region).put(rose, quantity);
                    }else{
                        roses.get(region).put(rose, roses.get(region).get(rose) + quantity);
                    }

                    regionRoses.put(region, regionRoses.get(region) + quantity);
                }
            }
        }


       roses.entrySet()
               .stream()
               .sorted((v1, v2) -> regionRoses.get(v2.getKey()).compareTo(regionRoses.get(v1.getKey())))
               .forEach(region -> {
                   System.out.println(region.getKey());
                   region.getValue().entrySet()
                           .stream()
                           .sorted((v1, v2) -> v1.getValue().compareTo(v2.getValue()))
                           .forEach(rose -> {
                               System.out.printf("*--%s | %d%n", rose.getKey(), rose.getValue());
                           });
               });

    }
}
