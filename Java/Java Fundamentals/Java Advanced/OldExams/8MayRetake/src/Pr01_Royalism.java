import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pr01_Royalism {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNames = reader.readLine().split(" ");

        ArrayList<String> royalists = new ArrayList<>();
        ArrayList<String> nonRoyalists = new ArrayList<>();

        for (String inputName : inputNames) {
            long sum = 0;

            for (char c : inputName.toCharArray()) {
                sum+= (int)c;
                while (sum > 26){
                    sum -= 26;
                }

            }
            if(sum == 18){
                royalists.add(inputName);
            }else{
                nonRoyalists.add(inputName);
            }
        }

        if(!royalists.isEmpty()){
            if(royalists.size() >= nonRoyalists.size()){
                System.out.println("Royalists - " + royalists.size());
                for (String royalist : royalists) {
                    System.out.println(royalist);
                }
                System.out.println("All hail Royal!");
            }else{
                for (String nonRoyalist : nonRoyalists) {
                    System.out.println(nonRoyalist);
                }
                System.out.println("Royalism, Declined!");
            }
        }else{
            for (String nonRoyalist : nonRoyalists) {
                System.out.println(nonRoyalist);
            }
            System.out.println("Royalism, Declined!");
        }
    }
}
