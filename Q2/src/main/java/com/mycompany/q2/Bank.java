/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Q2;

import java.util.*;

public class Bank {

    private int accNum;
    private String name;
    private double balance;

    public Bank(int accNum, String name, double balance) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
    }

    public Bank() {
    }

    public int getAccNum() {
        return accNum;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transferMoney(Bank receiver, double amount) {
        if (amount <= balance) {
            balance -= amount;
            receiver.deposit(amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accNum + ", Name: " + name + ", Balance: " + balance;
    }
     public List<Bank> inputAccounts() {
         Scanner scanner = new Scanner(System.in);
        List<Bank> accounts = new ArrayList<>();

        System.out.print("Enter the number of accounts: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for account " + (i + 1) + ":");
            System.out.print("Account Number: ");
            int accNum = scanner.nextInt();
            System.out.print("Full Name: ");
            scanner.nextLine(); // consume newline
            String name = scanner.nextLine();
            System.out.print("Initial Balance: ");
            double balance = scanner.nextDouble();

            Bank account = new Bank(accNum, name, balance);
            accounts.add(account);
        }

        return accounts;
    }
     public void outputAccounts(List<Bank> accounts) {
        for (Bank account : accounts) {
            System.out.println(account);
        }
    }
     public void performOperations(List<Bank> accounts) {
         Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose : ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer Money");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                performDeposit(accounts);
                break;
            case 2:
                performWithdraw(accounts);
                break;
            case 3:
                performTransfer(accounts);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public  void performDeposit(List<Bank> accounts) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number for deposit: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        for (Bank account : accounts) {
            if (account.getAccNum() == accNum) {
                account.deposit(amount);
                System.out.println("Deposit successful. New balance: " + account);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public  void performWithdraw(List<Bank> accounts) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number for withdrawal: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        for (Bank account : accounts) {
            if (account.getAccNum() == accNum) {
                account.withdraw(amount);
                System.out.println("Withdrawal successful. New balance: " + account);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public  void performTransfer(List<Bank> accounts) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sender account number: ");
        int senderAccNum = scanner.nextInt();
        System.out.print("Enter receiver account number: ");
        int receiverAccNum = scanner.nextInt();
        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();

        Bank sender = null;
        Bank receiver = null;

        for (Bank account : accounts) {
            if (account.getAccNum() == senderAccNum) {
                sender = account;
            }
            if (account.getAccNum() == receiverAccNum) {
                receiver = account;
            }
        }

        if (sender != null && receiver != null) {
            sender.transferMoney(receiver, amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Sender or receiver account not found.");
        }
    }
}