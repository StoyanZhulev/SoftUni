package Ex04_SetsAndMaps;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Pr11_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Long> userAndTime = new TreeMap<>();
        TreeMap<String, TreeSet<String>> userAndIp = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] logArgs = scanner.nextLine().split(" ");

            String ip = logArgs[0];
            String username = logArgs[1];
            Long duration = Long.parseLong(logArgs[2]);

            if(!userAndIp.containsKey(username)){
                userAndIp.put(username, new TreeSet<>());
                userAndIp.get(username).add(ip);
                userAndTime.put(username, duration);
            }else{
                userAndIp.get(username).add(ip);
                userAndTime.put(username, (userAndTime.get(username) + duration));
            }
        }

        for (String user : userAndTime.keySet()) {
            System.out.print(user + ": "+ userAndTime.get(user) + " [");
            int count = 0;
            for (String ip : userAndIp.get(user)) {
                if(count != userAndIp.get(user).size() - 1){
                    System.out.printf("%s, ", ip);
                }else{
                    System.out.printf("%s]%n", ip);
                }
                count++;
            }
        }
    }
}
