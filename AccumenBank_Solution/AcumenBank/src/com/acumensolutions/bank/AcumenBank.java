package com.acumensolutions.bank;

import account.CheckingAccount;
import account.SavingsAccount;

public class AcumenBank {

	public static void main(String[] args) {
		System.out.println("Welcome to Acumen Bank!");
		System.out.println();

		CheckingAccount michaelsAccount = new CheckingAccount("Michael", 5000);
		CheckingAccount gobsAccount = new CheckingAccount("Gob", 2000);

		System.out.println("Open Accounts:");
		System.out.println();
		printAccountDetails(michaelsAccount);
		System.out.println();
		printAccountDetails(gobsAccount);

		System.out.println();
		System.out.println("Making transfer of $1000...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			return;
		}

		michaelsAccount.transfer(gobsAccount, 1000);
		michaelsAccount.withdraw(1000); //Issue corrected here: with the transfer happens to destination account, the withdraw also needs to happen on source account

		System.out.println("Updated Account Details:");
		System.out.println();
		printAccountDetails(michaelsAccount);
		System.out.println();
		printAccountDetails(gobsAccount);

		// sample code for savings account implementation

		// Initialize new savings account with initial balance of $30,000 and 0.89% interest
		SavingsAccount acesSavingsAccount = new SavingsAccount("Ace", 30000, .0089);
		SavingsAccount garysSavingsAccount = new SavingsAccount("Gary", 10000, .0056);
		
		System.out.println();System.out.println();
		System.out.println("Aces Savings Account Balance Before Transfer: "+acesSavingsAccount.getBalance());
		System.out.println("Garys Savings Account Balance Before Transfer: "+garysSavingsAccount.getBalance());
		
		acesSavingsAccount.transfer(garysSavingsAccount, 5000);
		acesSavingsAccount.withdraw(5000); //withdraw needs to happen from Ace's account after the transfer to Gary's account
		
		System.out.println("Aces Savings Account Balance After Transfer: "+acesSavingsAccount.getBalance());
		System.out.println("Garys Savings Account Balance After Transfer: "+garysSavingsAccount.getBalance());
		
		// apply 2 years of interest to the savings accounts
		acesSavingsAccount.applyInterest(2);
		garysSavingsAccount.applyInterest(2);
		
		System.out.println("Aces Savings Account Balance After applying interest: "+acesSavingsAccount.getBalance());
		System.out.println("Garys Savings Account Balance After applying interest: "+garysSavingsAccount.getBalance());
	}

	private static void printAccountDetails(CheckingAccount account) {
		System.out.format("Account for %s:\r\n", account.getOwnerName());
		System.out.format("Balance: $%.2f\r\n", account.getBalance());
	}
}