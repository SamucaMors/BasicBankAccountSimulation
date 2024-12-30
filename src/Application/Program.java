package Application;

import Entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        double initialDeposit;
        Account account;

        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("\nEnter holder name: ");
        scanner.nextLine();
        String holderName = scanner.nextLine();

        System.out.print("\nDo you want to start the account with a deposit? (y/n): )");
        char entryWithDeposit = scanner.next().charAt(0);

        System.out.println(" ");

        if(entryWithDeposit == 'y'){
            System.out.print("Enter the initial deposit: ");
            initialDeposit = scanner.nextDouble();
            account = new Account(accountNumber, holderName, initialDeposit);
            System.out.println(account);
        }else{
            System.out.println("Ok");
            account = new Account(accountNumber, holderName);
            System.out.println(account);
        }

        menu(account, scanner);
        System.out.println(account);

        scanner.close();
    }
    public static void menu(Account account ,Scanner scanner){
        int option;
        do {
            System.out.println("""
                    \nMENU
                        1. Deposit
                        2. Withdrawal
                        3. Exit""");
            option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    double deposit;
                    do {
                        System.out.print("\nEnter the amount to be deposited: ");
                        deposit = scanner.nextDouble();
                        if (deposit <= 0) {
                            System.out.println("Invalid deposit amount! Please enter a positive value.");
                        }
                    } while (deposit <= 0);
                    account.handleDeposit(deposit);
                case 2:
                    double withdraw;
                    do {
                        System.out.print("\nEnter the amount to be withdrawn: ");
                        withdraw = scanner.nextDouble();
                        if (withdraw <= 0) {
                            System.out.println("Invalid withdrawal amount! Please enter a positive value.");
                        } else if (withdraw > account.getBalance()) {
                            System.out.println("Insufficient funds! Please enter a smaller amount.");
                        }
                    } while (withdraw <= 0 || withdraw > account.getBalance());
                    account.handleWithdrawal(withdraw);
                case 3:
                    System.out.println("Bye bye\n");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }while(option != 3);
    }
}