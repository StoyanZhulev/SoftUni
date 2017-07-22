package Pr05_GenericCountMethodString;

import java.util.List;

public class Count {

    @SuppressWarnings("unchecked")
    public static <T extends Comparable> int count(List<T> list, T elToCompare){
        int count = 0;
        for (T t : list) {
            if(elToCompare.compareTo(t) < 0){
                count++;
            }
        }

        return count;
    }
}
