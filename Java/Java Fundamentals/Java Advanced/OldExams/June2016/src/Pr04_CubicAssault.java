import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Pr04_CubicAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, TreeMap<String, Long>> regionMeteors = new TreeMap<>();

        while (true) {
            String line = reader.readLine();

            if ("Count em all".equals(line)) {
                break;
            }

            String[] lineArgs = line.split(" -> ");

            String region = lineArgs[0];
            String type = lineArgs[1];
            long count = Long.parseLong(lineArgs[2]);


            if (!regionMeteors.containsKey(region)) {
                regionMeteors.put(region, new TreeMap<>());
                regionMeteors.get(region).put("Red", 0L);
                regionMeteors.get(region).put("Green", 0L);
                regionMeteors.get(region).put("Black", 0L);
            }

            regionMeteors.get(region).put(type, regionMeteors.get(region).get(type) + count);

            if (regionMeteors.get(region).get("Green") >= 1000000) {
                regionMeteors.get(region).put("Red", regionMeteors.get(region).get("Red") + regionMeteors.get(region).get("Green") / 1000000);
                regionMeteors.get(region).put("Green", regionMeteors.get(region).get("Green") % 1000000);
            }

            if (regionMeteors.get(region).get("Red") >= 1000000) {
                regionMeteors.get(region).put("Black", regionMeteors.get(region).get("Black") + regionMeteors.get(region).get("Red") / 1000000);
                regionMeteors.get(region).put("Red", regionMeteors.get(region).get("Red") % 1000000);
            }

        }


       regionMeteors.entrySet().stream().sorted((r1, r2) -> {
           long v1 = r1.getValue().get("Black");
           long v2 = r2.getValue().get("Black");

           if (v1 != v2) {
               return Long.compare(v2, v1);
           } else {
               int k1Length = r1.getKey().length();
               int k2Length = r2.getKey().length();
               return Integer.compare(k1Length, k2Length);
           }
       }).forEach(region -> {
           System.out.println(region.getKey());

           region.getValue().entrySet().stream()
                   .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))
                   .forEach(meteor -> System.out.printf("-> %s : %d%n"
                           , meteor.getKey()
                           , meteor.getValue()));
       });

    }
}
