/*
Пример ООП.
 */
package java2024_datastructures;

class BankAccount {
    private double balance;

    public BankAccount(double openingBalance) {
        balance = openingBalance;
    }

    public void deposit (double amount){
        balance+= amount;
    }
    
    public void withdraw (double amount){
        balance-= amount;
    }
   
    public void pisplay(){
        System.out.println("The balance: "+balance);
    }
}


public class L01_01_BankApp {
    public static void main (String [] args){
        BankAccount bal = new BankAccount(100.00);
        System.out.println("Before transactions");
        bal.pisplay();
        bal.deposit(44);
        bal.withdraw(36);
        System.out.println("After transactions");
        bal.pisplay();
    }
}
