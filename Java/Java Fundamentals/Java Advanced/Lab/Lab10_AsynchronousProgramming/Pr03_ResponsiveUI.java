package Lab10_AsynchronousProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Pr03_ResponsiveUI {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Runnable task = () -> primesInRange(10000000);

        Thread thread = new Thread(task);

        thread.start();

        while(true){
            String command = reader.readLine();
            if(command.equals("stop")){
                thread.interrupt();
            }
        }
    }

    public static void primesInRange(int number){
        List<Integer> primes = new ArrayList<>();
        for (int primeCandidate = 0; primeCandidate <= number; primeCandidate++) {
            if(isPrime(primeCandidate)){
                primes.add(primeCandidate);
            }

            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted...");
                break;
            }
        }
        System.out.println("Primes found: " + primes.size());
    }

    public static boolean isPrime(int num) {
        if(num < 2){
            return false;
        }

        //math.sqrt || i * i
        for (int i = 2; i < num; i++) {
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

}
