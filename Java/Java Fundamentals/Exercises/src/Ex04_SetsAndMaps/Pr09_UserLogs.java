package Ex04_SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pr09_UserLogs {
    private static Integer counter = 0;
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();

        while (!input.equals("end")) {
            String[] inputArgs = input.split(" ");
            String[] IP = inputArgs[0].split("=");
            String[] messageArgs = inputArgs[1].split("=");
            String[] userArgs = inputArgs[2].split("=");

            String ipAddress = IP[1];
            String message = messageArgs[1];
            String user = userArgs[1];

            if (!userLogs.containsKey(user)) {
                userLogs.put(user, new LinkedHashMap<>());
                userLogs.get(user).put(ipAddress, 1);
            } else {
                if (!userLogs.get(user).containsKey(ipAddress)) {
                    userLogs.get(user).put(ipAddress, 1);
                } else {
                    userLogs.get(user).put(ipAddress, userLogs.get(user).get(ipAddress) + 1);
                }
            }
            input = console.nextLine();
        }

        for (Map.Entry user : userLogs.entrySet()) {
            System.out.println(user.getKey() + ":");
            int count = 0;

            for (Map.Entry ip : userLogs.get(user.getKey()).entrySet()) {
                if (count == userLogs.get(user.getKey()).entrySet().size() - 1) {
                    System.out.printf("%s => %s.%n", ip.getKey(), ip.getValue());
                } else {
                    System.out.printf("%s => %s, ", ip.getKey(), ip.getValue());
                }
                count++;
            }
        }

        userLogs.entrySet().forEach(u -> {
            System.out.println(u.getKey() + " ");

            u.getValue().entrySet().forEach(ip -> {

                if (counter == userLogs.get(u.getKey()).entrySet().size() - 1) {
                    System.out.printf("%s => %s.%n", ip.getKey(), ip.getValue());
                } else {
                    System.out.printf("%s => %s, ", ip.getKey(), ip.getValue());
                }
                counter++;
            });
        });
    }
}
