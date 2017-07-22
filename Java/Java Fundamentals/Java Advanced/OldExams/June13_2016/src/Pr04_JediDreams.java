import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Pr04_JediDreams {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        TreeMap<String, ArrayList<String>> methods = new TreeMap<>();
        Pattern pattern = Pattern.compile("([a-zA-Z]*[A-Z]+[A-Za-z]*)\\s*\\(");
        String method = "";
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            Matcher matcher = pattern.matcher(line);

            if (line.trim().startsWith("static")) {
                if(matcher.find()) {
                    method = matcher.group(1);
                    methods.put(method, new ArrayList<>());
                }
            }
            while (matcher.find()) {
                methods.get(method).add(matcher.group(1));
            }
        }

        methods.entrySet().stream()
                .sorted((m1, m2) -> Long.compare(m2.getValue().size(), m1.getValue().size()))
                .forEach(m ->{
                    if(m.getValue().isEmpty()){
                        System.out.printf("%s -> None%n", m.getKey());
                    }else{
                        System.out.printf("%s -> %s -> ", m.getKey(), m.getValue().size());
                        ArrayList<String> currList = m.getValue();
                        Collections.sort(currList);
                        StringBuilder result = new StringBuilder();
                        for (String s : currList) {
                            result.append(s).append(", ");
                        }
                        result.delete(result.length() - 2, result.length());

                        System.out.println(result);
                    }
                });
//        methods.entrySet().stream()
//                .sorted((a, b) -> Long.compare(b.getValue().size(), a.getValue().size()))
//                .forEach(m -> {
//                    if (m.getValue().isEmpty()) {
//                        System.out.printf("%s -> None%n", m.getKey());
//                    } else {
//                        System.out.printf("%s -> %d -> %s%n",
//                                m.getKey(),
//                                m.getValue().size(),
//                                String.join(", ", m.getValue()
//                                        .stream()
//                                        .sorted(String::compareTo)
//                                        .collect(Collectors.toList())));
//                    }
//
//                });

    }
}
