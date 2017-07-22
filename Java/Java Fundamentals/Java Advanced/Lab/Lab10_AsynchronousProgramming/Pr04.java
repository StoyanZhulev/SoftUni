package Lab10_AsynchronousProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.BooleanSupplier;

public class Pr04 {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Integer numberCount = Integer.parseInt(reader.readLine());
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Boolean>[] results = new Future[numberCount];

        long start = System.nanoTime();
        for (int i = 0; i < numberCount; i++) {
            int primeCandidate = i;
            results[i] = executorService.submit(() -> isPrime(primeCandidate));
        }

        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        executorService.shutdown();

        for (int i = 0; i < results.length; i++) {
            System.out.printf("%d -> %s%n", i, results[i].get());
        }

        System.out.println(System.nanoTime() - start);
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
