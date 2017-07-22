package Pr03_GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> sc = new Scale<>(5, 6);

        System.out.println(sc.getHeavier());
    }
}
