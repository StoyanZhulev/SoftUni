package Pr04_ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1, 5, 87 ,8 , 87,78);

        System.out.println(ListUtils.getMax(ints));
    }
}
