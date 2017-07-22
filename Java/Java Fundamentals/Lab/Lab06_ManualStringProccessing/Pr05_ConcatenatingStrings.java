package Lab06_ManualStringProccessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr05_ConcatenatingStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();

        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(reader.readLine());
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
