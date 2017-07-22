import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Pr01_SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] flower = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] bucket = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> flowers = new ArrayDeque<>();
        Deque<Integer> water = new ArrayDeque<>();
        ArrayList<Integer> secondNature = new ArrayList<>();

        for (int i = 0; i < flower.length; i++) {
            flowers.add(flower[i]);
        }

        for (int i = 0; i < bucket.length; i++) {
            water.push(bucket[i]);
        }

        while(!water.isEmpty() && !flowers.isEmpty()){
            int currWater = water.peek();
            int currFlower = flowers.peek();

            int remainigWater = currWater - currFlower;

            if(remainigWater == 0){
                flowers.poll();
                secondNature.add(currFlower);
                water.pop();
            }else if(remainigWater > 0){
                flowers.poll();
                if(water.size() > 1){
                    water.pop();
                    int nextBuck = water.pop() + remainigWater;
                    water.push(nextBuck);
                }else{
                    water.pop();
                    water.push(remainigWater);
                }
            }else{
                flowers.poll();
                currFlower -= currWater;
                water.pop();
                flowers.addFirst(currFlower);
            }
        }

        if(!water.isEmpty()){
            int size = water.size();
            for (int i = 0; i < size; i++) {
                System.out.print(water.pop() + " ");
            }
        }else{
            int size = flowers.size();
            for (int i = 0; i < size; i++) {
                System.out.print(flowers.poll() + " ");
            }
        }
        System.out.println();
        if(!secondNature.isEmpty()){
            for (int i = 0; i < secondNature.size(); i++) {
                System.out.print(secondNature.get(i) + " ");
            }
        }else{
            System.out.println("None");
        }
    }
}
