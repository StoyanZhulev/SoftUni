import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Pr01_JediMeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());

        Deque<String> jedisOrder = new ArrayDeque<>();
        Deque<String> masters = new ArrayDeque<>();
        Deque<String> knights = new ArrayDeque<>();
        Deque<String> padowans = new ArrayDeque<>();
        Deque<String> toshkoSlav = new ArrayDeque<>();
        boolean isYodaWatching = false;
        for (int i = 0; i < lines; i++) {
            String[] jedis = reader.readLine().split(" ");

            for (String jedi : jedis) {
                char jedyType = jedi.charAt(0);
                switch (jedyType) {
                    case 'm':
                        masters.add(jedi);
                        break;
                    case 'k':
                        knights.add(jedi);
                        break;
                    case 'p':
                        padowans.add(jedi);
                        break;
                    case 's':
                    case 't':
                        toshkoSlav.add(jedi);
                        break;
                    case 'y':
                        isYodaWatching = true;
                        break;

                }
            }
        }

        StringBuilder output = new StringBuilder();

        if(isYodaWatching){
            while(!masters.isEmpty()){
                output.append(masters.poll()).append(" ");
            }
            while(!knights.isEmpty()){
                output.append(knights.poll()).append(" ");
            }
            while (!toshkoSlav.isEmpty()){
                output.append(toshkoSlav.poll()).append(" ");
            }
            while(!padowans.isEmpty()){
                output.append(padowans.poll()).append(" ");
            }
        }else{
            while (!toshkoSlav.isEmpty()){
                output.append(toshkoSlav.poll()).append(" ");
            }
            while(!masters.isEmpty()){
                output.append(masters.poll()).append(" ");
            }
            while(!knights.isEmpty()){
                output.append(knights.poll()).append(" ");
            }
            while(!padowans.isEmpty()){
                output.append(padowans.poll()).append(" ");
            }
        }

        System.out.println(output);
    }
}
