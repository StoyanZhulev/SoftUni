package Pr02_GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        Integer[] i = ArrayCreator.create(Integer.class, 5, 1);
        Object[] s = ArrayCreator.create(10, "name");

        System.out.println(s.length);
        System.out.println(i.length);
    }
}
