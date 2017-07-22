package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static CustomArray<?> test;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        try{
            CustomArray<Integer> arr = new CustomArrayImpl<>();
            int a = Integer.parseInt(input);
            arr.addElement(a);
            test = arr;
        }catch (Exception e){
            CustomArray<String> arr = new CustomArrayImpl<>();
            arr.addElement(input);
            test = arr;
        }

        CustomArray<Integer> arr = new CustomArrayImpl<>();
        arr.addElement(6);
        test = arr;

        System.out.println(test.getFirstElement());
    }
}
