package Pr01_BankAccountAndTestClient;

public class BankAccount {
    public int id;
    public double balance;

    public void setId(int id){
        this.id = id;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Amount should be non-negative.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount){

        if(this.balance < amount){
            throw new IllegalStateException("Insufficient balance.");
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
