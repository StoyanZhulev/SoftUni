package Pr02_StaticIdAndRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        String command = reader.readLine();

        while (!"End".equals(command)){
            String[] cmdArgs = command.split(" ");

            String cmdType = cmdArgs[0];
            switch (cmdType){
                case "Create":
                    execCreate(accounts);
                    break;
                case "Deposit":
                    execDeposit(cmdArgs, accounts);
                    break;
                case "SetInterest":
                    execSetInterest(cmdArgs, accounts);
                    break;
                case "GetInterest":
                    execGetInterest(cmdArgs, accounts);
                    break;
            }

            command = reader.readLine();
        }
    }

    private static void execGetInterest(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);

        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
            return;
        }

        int years = Integer.parseInt(cmdArgs[2]);

        BankAccount account = accounts.get(id);

        double interest = account.getInterest(years);
        System.out.printf("%.2f%n", interest);
    }

    private static void execSetInterest(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        double interest = Double.valueOf(cmdArgs[1]);

        BankAccount.setInterest(interest);
    }

    private static void execDeposit(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
            return;
        }

        double amount = Double.parseDouble(cmdArgs[2]);
        BankAccount account = accounts.get(id);
        account.deposit(amount);
    }

    private static void execCreate(HashMap<Integer, BankAccount> accounts) {
        BankAccount account = new BankAccount();
        System.out.println("Account " + account + " created");

        int id = account.getId();
        accounts.put(id, account);
    }
}
