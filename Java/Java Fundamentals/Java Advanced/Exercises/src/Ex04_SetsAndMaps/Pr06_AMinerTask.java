package Ex04_SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pr06_AMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String resourcetype = console.nextLine();

        LinkedHashMap<String, Long> resources = new LinkedHashMap<>();

        while(!resourcetype.equals("stop")){
            long resourceQuantity = Long.parseLong(console.nextLine());

            if(!resources.containsKey(resourcetype)){
                resources.put(resourcetype, resourceQuantity);
            }else{
                resources.put(resourcetype, resources.get(resourcetype) + resourceQuantity);
            }

            resourcetype = console.nextLine();
        }

        for (Map.Entry entry : resources.entrySet()){
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
