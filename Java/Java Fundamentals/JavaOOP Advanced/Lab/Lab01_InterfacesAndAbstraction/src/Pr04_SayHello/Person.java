package Pr04_SayHello;

public interface Person {
    String getName();

    default String sayHello(){
        return "Hello";
    }
}
