package Pr05_CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "Pesho")
    public static void printMethodsByAuthor(){
        Class<?> trackerClass = Tracker.class;
        Method[] declaredMethods = trackerClass.getDeclaredMethods();

        Map<String, List<String>> methodsByAuthor = new HashMap<>();

        for (Method method : declaredMethods) {
            Author annotation = method.getAnnotation(Author.class);
            if(annotation != null){
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName());
            }
        }

        for (String author : methodsByAuthor.keySet()) {
            System.out.printf("%s: %s", author, String.join(", ", methodsByAuthor.get(author)));
        }
    }
}
