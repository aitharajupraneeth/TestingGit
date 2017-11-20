package account;
import static java.lang.Math.pow;

public class SavingsAccount {
	private String ownerName;
	private double balance;
	private double interest;

	public SavingsAccount(String ownerName, double balance, double interest) {
		this.ownerName = ownerName;
		this.balance = balance;
		this.interest = interest;
	}

	public void transfer(SavingsAccount destinationAccount, double amount) {
		destinationAccount.deposit(amount);
	}

	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot deposit a negative amount");
		}
		this.balance += amount;
	}

	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Cannot withdraw a negative amount");
		}
		this.balance -= amount;
	}
	
	public void applyInterest(int noOfYears){
		double principle = getBalance();
		double rate = getInterest();
		rate = (1 + rate / 1);
		rate = pow(rate,noOfYears);
		principle = principle * rate;
		this.balance = principle;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public double getBalance() {
		return this.balance;
	}
	
	public double getInterest(){
		return this.interest;
	}

}
