import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pr03_NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char lastChar = 'a';
        boolean wasIn = false;
        String line = reader.readLine();

        while(true){
            if("---NMS SEND---".equals(line)){
                break;
            }

                if (words.isEmpty() && sb.length() == 0) {
                    sb.append(line.charAt(0));
                } else {
                    if (lastChar <= line.toLowerCase().charAt(0)) {
                        sb.append(line.charAt(0));
                    } else {
                        if (sb.toString().length() > 0) {
                            words.add(sb.toString());
                        }
                        sb.delete(0, sb.length());
                        sb.append(line.charAt(0));
                    }
                }

                for (int ch = 0; ch < line.length() - 1; ch++) {
                    if (line.toLowerCase().charAt(ch) <= line.toLowerCase().charAt(ch + 1)) {
                        sb.append(line.charAt(ch + 1));
                    } else {
                        words.add(sb.toString());
                        sb.delete(0, sb.length());
                        sb.append(line.charAt(ch + 1));
                        wasIn = true;
                    }
                }
                lastChar = line.toLowerCase().charAt(line.length() - 1);
                line = reader.readLine();
                if ("---NMS SEND---".equals(line)) {
                    words.add(sb.toString());
                }
                if (sb.length() > 1 && !wasIn && !"---NMS SEND---".equals(line)) {
                    words.add(sb.toString());
                    sb.delete(0, sb.length());
                }
        }

        String delimiter = reader.readLine();

        System.out.println(String.join(delimiter, words));
    }
}
