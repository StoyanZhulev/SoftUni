package Ex02_MultidimensionalArrays;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pr13_ActivityTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<Integer, TreeMap<String, Long>> activity = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String[] date = input[0].split("/");

            int month = Integer.parseInt(date[1]);
            String name = input[1];
            long distance = Long.parseLong(input[2]);

            if(!activity.containsKey(month)){
                activity.put(month, new TreeMap<>());
                activity.get(month).put(name, distance);
            }else{
                if(!activity.get(month).containsKey(name)){
                    activity.get(month).put(name, distance);
                }else{
                    activity.get(month).put(name, activity.get(month).get(name) + distance);
                }
            }
        }

        for (Map.Entry<Integer, TreeMap<String, Long>> user : activity.entrySet()) {
            System.out.print(user.getKey() + ": ");

            int count = 0;
            for (Map.Entry userActivity : activity.get(user.getKey()).entrySet()) {
                if(count == activity.get(user.getKey()).entrySet().size() - 1){
                    System.out.printf("%s(%s)%n", userActivity.getKey(), userActivity.getValue());
                }else{
                    System.out.printf("%s(%s), ", userActivity.getKey(), userActivity.getValue());
                }
                count++;
            }
        }
    }
}
