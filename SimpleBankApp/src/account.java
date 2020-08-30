
public class account {

	private int balance;
	private String user;
	
	public account(String user, int balance) {
		this.user = user;
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		this.balance += amount;
		System.out.println(amount + " deposited in " + this.getUser() + "'s account.");
	}
	
	public void withdraw(int amount) {
		if(this.balance > amount) {
			this.balance -= amount;
			System.out.println(amount + " withdrawn from " + this.getUser() + "'s account.");
		}
		else {
			System.out.println("Account balance is insufficient");
		}
	}
	
	public void transfer(int amount, account account) {
		if (this.balance > amount) {
			this.withdraw(amount);
			account.deposit(amount);
		}
		else {
			System.out.println("Transferor ccount balance is insufficient.");
		}
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public String getUser() {
		return this.user;
	}
}