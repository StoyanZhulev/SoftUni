package Ex03_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Pr05_SequenceWithQueue {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        long n = Long.parseLong(console.nextLine());

        ArrayDeque<Long> queue = new ArrayDeque<>();

        queue.add(n);
        for (int i = 0; i < 50; i++) {
            long current = queue.poll();

            System.out.printf("%s ", current);

            long s1 = current + 1;
            long s2 = 2 * current + 1;
            long s3 = current + 2;

            queue.add(s1);
            queue.add(s2);
            queue.add(s3);
        }
    }
}
