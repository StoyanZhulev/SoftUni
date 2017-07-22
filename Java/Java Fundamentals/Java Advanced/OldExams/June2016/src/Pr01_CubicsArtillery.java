import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Pr01_CubicsArtillery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());

        Deque<Integer> weapons = new ArrayDeque<>();
        Deque<String> bunkers = new ArrayDeque<>();
        ArrayList<String> result = new ArrayList<>();

        String input = reader.readLine();

        while (!"Bunker Revision".equals(input)) {
            String[] inputArgs = input.split(" ");

            for (int i = 0; i < inputArgs.length; i++) {
                if (Character.isDigit(inputArgs[i].charAt(0))) {
                    int weapon = Integer.parseInt(inputArgs[i]);

                    if (weapon > capacity) {
                        print(bunkers.peek(), weapons);
                        bunkers.poll();
                        weapons.clear();
                    } else if (weapon <= capacity - weapons.stream().mapToInt(s -> s).sum()) {
                        weapons.add(weapon);
                    } else if (capacity < weapons.stream().mapToInt(s -> s).sum() + weapon && bunkers.size() > 1) {
                        print(bunkers.peek(), weapons);
                        bunkers.poll();
                        weapons.clear();
                        weapons.add(weapon);
                    } else if (weapon > capacity - weapons.stream().mapToInt(s -> s).sum()) {
                        while (weapon > capacity - weapons.stream().mapToInt(s -> s).sum()) {
                            weapons.poll();
                        }
                        weapons.add(weapon);
                    }
                } else {
                    bunkers.add(inputArgs[i]);
                }
            }

            input = reader.readLine();
        }
    }

    private static void print(String bunker, Deque<Integer> weapons) {
        StringBuilder sb = new StringBuilder();
        if (weapons.size() != 0) {
            sb.append(bunker). append(" -> ");
            for (Integer weapon : weapons) {
                sb.append(weapon).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            System.out.println(sb);
        } else {
            sb.append(bunker).append(" -> Empty");
        }
    }
}

