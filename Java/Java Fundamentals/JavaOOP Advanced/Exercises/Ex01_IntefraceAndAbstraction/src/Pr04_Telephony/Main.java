package Pr04_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = new ArrayList<>();
        List<String> sites = new ArrayList<>();

        String[] nums = reader.readLine().split(" ");
        String[] site = reader.readLine().split(" ");

        for (String num : nums) {
            boolean isValid = true;
            for (char c : num.toCharArray()) {
                if(!Character.isDigit(c)){
                    isValid = false;
                }
            }
            if(isValid){
                numbers.add(num);
            }else{
                numbers.add("Invalid number!");
            }
        }

        for (String sit : site) {
            boolean isValid = true;
            for (char c : sit.toCharArray()) {
                if(Character.isDigit(c)){
                    isValid = false;
                }
            }
            if(isValid){
                sites.add(sit);
            }else{
                sites.add("Invalid URL!");
            }
        }

        Smartphone sm = new Smartphone();

        for (String num : numbers) {
            if(!"Invalid number!".equals(num)){
                System.out.println(sm.call() + num);
            }else{
                System.out.println(num);
            }
        }

        for (String s : sites) {
            if(!"Invalid URL!".equals(s)){
                System.out.println(sm.browse() + s + "!");
            }else{
                System.out.println(s);
            }
        }
    }
}
