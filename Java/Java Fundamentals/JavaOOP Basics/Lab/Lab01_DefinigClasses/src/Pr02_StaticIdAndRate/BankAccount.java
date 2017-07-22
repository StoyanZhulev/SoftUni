package Pr02_StaticIdAndRate;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;

    private static int idCount = 1;

    private static double rate = DEFAULT_INTEREST_RATE;

    private int id;
    private double balance;

    public BankAccount(){
        this.id = idCount++;
    }

    public int getId(){
        return this.id;
    }

    public static void setInterest(double interest){
        rate = interest;
    }

    public void deposit(double amount){
        System.out.printf("Deposited %.0f to %s%n", amount, this);
        this.balance += amount;
    }

    public double getInterest(int years){
        return this.balance * rate * years;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
