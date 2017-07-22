import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr03_JediCodeX {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Deque<String> jedis = new ArrayDeque<>();
        ArrayList<String> messeges = new ArrayList<>();
        LinkedHashMap<String, String> jediMesseges = new LinkedHashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            sb.append(line);
        }

        String namePAttern = reader.readLine();
        String messegePattern = reader.readLine();

        Pattern patternName = Pattern.compile("(" + namePAttern + "([a-zA-Z]{"+ namePAttern.length() + "})(?=[^a-zA-Z]))");
        Pattern patternMessege = Pattern.compile("(" + messegePattern + "([a-zA-Z0-9]{" + messegePattern.length() + "})(?=[^a-zA-Z0-9]))");

        Matcher nameMatcher = patternName.matcher(sb);
        Matcher messegeMatcher = patternMessege.matcher(sb);

        while(nameMatcher.find()){
            String name = nameMatcher.group(2);
            jedis.add(name);
        }

        while(messegeMatcher.find()){
            String messege = messegeMatcher.group(2);
            messeges.add(messege);
        }

        int[] indexes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < indexes.length; i++) {
            if(indexes[i] <= messeges.size()){
                if(!jedis.isEmpty()){
                    jediMesseges.put(jedis.poll(), messeges.get(indexes[i] - 1));
                }
            }
        }

        for (String jedi : jediMesseges.keySet()) {
            System.out.println(jedi + " - " + jediMesseges.get(jedi));
        }
    }
}
