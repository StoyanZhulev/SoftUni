package Pr05_NullFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1, 5, 4 ,null, 54, null);

        System.out.println(ListUtils.getNullIndices(ints));
    }
}
