package Pr03_GenericSwapMethodStrings;

import java.util.List;

public class ListSwap {
    public static <T> List<T> swap(List<T> list, int index1, int index2){
        T element = list.get(index1);

        list.set(index1, list.get(index2));
        list.set(index2, element);

        return list;
    }

    public static <T> void print(List<T> list){
        for (T t : list) {
            String out = t.getClass() +": "+ t;
            System.out.println(out.substring(6));
        }
    }
}
