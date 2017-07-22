package Lab04_SetsAndMaps;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Pr03_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>();

        for (int i = 0; i < 20; i++) {
            int number = Integer.parseInt(scanner.next());
            firstPlayer.add(number);
        }
        for (int i = 0; i < 20; i++) {
            int number = Integer.parseInt(scanner.next());
            secondPlayer.add(number);
        }
        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }

            Iterator<Integer> iteratorFirst = firstPlayer.iterator();
            int firstNumber = iteratorFirst.next();
            firstPlayer.remove(firstNumber);

            Iterator<Integer> iteratorSecond = secondPlayer.iterator();
            int secondNumber = iteratorSecond.next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (firstNumber < secondNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
        }
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}

