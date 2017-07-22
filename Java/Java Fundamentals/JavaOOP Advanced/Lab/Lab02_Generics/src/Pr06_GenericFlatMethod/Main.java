package Pr06_GenericFlatMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1, 54,15,4,5,8,4,523);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.0, 54.2,15.5,4.5,5.5,8.4,4.4,523.1);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, ints, doubles);

        List<Number> numbers = new ArrayList<>();
        ListUtils.flatten(numbers, jagged);

        System.out.println(numbers);
    }
}
