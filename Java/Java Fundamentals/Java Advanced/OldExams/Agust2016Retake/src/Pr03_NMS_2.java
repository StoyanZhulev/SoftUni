import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pr03_NMS_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();

        while (!"---NMS SEND---".equals(line)){
            sb.append(line);
            line = reader.readLine();
        }

        String text = sb.toString();
        sb.delete(0, sb.length());
        for (int i = 0; i < text.length() - 1; i++) {
            sb.append(text.charAt(i));
            if(text.toLowerCase().charAt(i) > text.toLowerCase().charAt(i + 1)){
                words.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        sb.append(text.charAt(text.length() - 1));
        words.add(sb.toString());

        String delimiter = reader.readLine();

        System.out.println(String.join(delimiter, words));
    }
}
