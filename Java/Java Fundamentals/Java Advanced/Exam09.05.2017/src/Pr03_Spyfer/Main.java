package Pr03_Spyfer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split(" ");
        List<Integer> nums = new ArrayList<>();

        for (String number : numbers) {
            nums.add(Integer.parseInt(number));
        }

        int index = 0;
        while (index <= nums.size()){
            for (int i = 0; i < nums.size(); i++) {
                int previous = 0;
                int next = 0;
                if(i != 0){
                    previous = nums.get(i - 1);
                }
                if(i != nums.size() - 1){
                    next = nums.get(i + 1);
                }

                List<Integer> temp = new ArrayList<>();
                temp.addAll(nums);



                if(temp.get(i) == previous + next){
                    if(i != 0 && i < nums.size() - 1){
                        temp.remove(i - 1);
                        temp.remove(i);
                    }else if(i == nums.size() - 1){
                        temp.remove(i - 1);
                    }else if(i == 0){
                        temp.remove(i + 1);
                    }
                    i = -1;
                }
                nums = temp;
            }
            index++;
        }

        for (Integer num : nums) {
            System.out.printf("%d ", num);
        }
    }
}
