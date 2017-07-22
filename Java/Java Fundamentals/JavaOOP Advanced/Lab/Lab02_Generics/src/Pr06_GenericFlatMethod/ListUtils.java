package Pr06_GenericFlatMethod;

import java.util.List;

public class ListUtils {

    public static <T> void flatten(List<? super T> dest, List<List<? extends T>> src){
        for (List<? extends T> inner : src) {
            dest.addAll(inner);
        }
    }
}
