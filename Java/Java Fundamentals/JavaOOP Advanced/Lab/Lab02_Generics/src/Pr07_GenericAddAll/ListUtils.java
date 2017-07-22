package Pr07_GenericAddAll;

import java.util.List;

public class ListUtils {

    public static <T> void addAll(List<? super T> dest, List<? extends T> src){
        dest.addAll(src);
    }
}
