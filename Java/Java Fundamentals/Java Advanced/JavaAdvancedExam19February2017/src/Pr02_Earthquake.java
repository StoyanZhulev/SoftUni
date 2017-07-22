import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Pr02_Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Deque<List<Integer>> lines = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            ArrayList<Integer> currLine = new ArrayList<>();

            for (String s : line) {
                currLine.add(Integer.parseInt(s));
            }
            lines.add(currLine);
        }

        long seizmicities = 0;
        StringBuilder output = new StringBuilder();
        while(!lines.isEmpty() && lines.peek().size() >= 1){
            List<Integer> currentLine = lines.poll();
            int seizmicity =   currentLine.get(0);
            seizmicities++;
            for (int i = 1; i < currentLine.size(); i++) {
                if(currentLine.get(i) > seizmicity){
                    List<Integer> listToAdd = currentLine.subList(i, currentLine.size());
                    lines.add(listToAdd);
                    break;
                }
            }

            output.append(seizmicity).append(" ");
        }

        System.out.println(seizmicities);
        System.out.println(output);
    }
}
