package Pr01_BankAccountAndTestClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();

        while(!"End".equals(command)){
            String[] cmdArgs = command.split(" ");
            String cmdType = cmdArgs[0];
            switch (cmdType){
                case "Create":
                    execCreate(cmdArgs, accounts);
                    break;
                case "Deposit":
                    execDeposit(cmdArgs, accounts);
                    break;
                case "Withdraw":
                    execWithdraw(cmdArgs, accounts);
                    break;
                case "Print":
                    execPrint(cmdArgs, accounts);
                    break;
            }

            command = reader.readLine();
        }
    }

    private static void execPrint(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(cmdArgs[1]);
        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
            return;
        }

        BankAccount account = accounts.get(id);
        System.out.printf("Account %s, balance %.2f%n", account, account.getBalance());
    }

    private static void execWithdraw(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(cmdArgs[1]);
        double amount = Double.valueOf(cmdArgs[2]);

        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
            return;
        }

        try{
            accounts.get(id).withdraw(amount);
        }catch (IllegalStateException ise){
            System.out.println(ise.getMessage());
        }
    }

    private static void execDeposit(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        double amount = Double.valueOf(cmdArgs[2]);

        if(!accounts.containsKey(id)){
            System.out.println("Account does not exist");
            return;
        }

        try{
            accounts.get(id).deposit(amount);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }

    private static void execCreate(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(cmdArgs[1]);
        if(accounts.containsKey(id)){
            System.out.println("Account already exists");
        }else{
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }
    }
}
