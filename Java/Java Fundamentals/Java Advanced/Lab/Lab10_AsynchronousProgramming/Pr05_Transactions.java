package Lab10_AsynchronousProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pr05_Transactions {
    public static void main(String[] args) throws InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BankAccount account = new BankAccount();
        Runnable task = () ->{
            for (int i = 0; i < 100; i++) {
                account.deposit(1);
            }
        };

        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(account.balance);
    }
}

class BankAccount {
    int balance;

    /*synchronized*/void deposit(int amount){
        synchronized(this){
            balance += amount;
        }
    }
}
