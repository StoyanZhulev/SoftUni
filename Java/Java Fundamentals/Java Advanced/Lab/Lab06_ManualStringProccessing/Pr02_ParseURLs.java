package Lab06_ManualStringProccessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pr02_ParseURLs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        String[] remainder = input.split("://");
        if(remainder.length != 2){
            System.out.println("Invalid URL");
        }else{
            System.out.println(String.format("Protocol = %s", remainder[0]));
            int index = remainder[1].indexOf("/");
            String server = String.format("Server = %s", remainder[1].substring(0, index));
            System.out.println(server);
            String resources = String.format("Resources = %s", remainder[1].substring(index + 1));
            System.out.println(resources);
        }
    }
}
