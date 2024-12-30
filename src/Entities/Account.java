package Entities;

public class Account {
    private int accountNumber;
    private double balance;
    private String holderName;
    private double initialDeposit;
    private static final double TAX = 5.00;

    public Account(int accountNumber, String holderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.initialDeposit = initialDeposit;
        deposit(initialDeposit);
    }

    public Account(int accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }


    public void deposit(double deposit) {
        this.balance += deposit;
    }

    public void withdraw(double saque) {
        this.balance -= (saque+TAX);
    }


    public void handleDeposit(double deposit){
        if (deposit > 0){
            deposit(deposit);
        }else{
            System.out.println("Insufficient value");
        }
    }

    public void handleWithdrawal(double withdraw){
        if (withdraw <= this.balance){
            withdraw(withdraw);
        }else if(withdraw > this.balance){
            System.out.println("Insufficient value");
        }else {
            System.out.println("Impossible to withdraw negative value");
        }
    }

    @Override
    public String toString() {
        return "Account" +
                "\nAccount number: " + accountNumber +
                "\nHolder Name: " + holderName +
                "\nBalance: " + balance +
                "\nInitial deposit: " + initialDeposit;
    }
}
