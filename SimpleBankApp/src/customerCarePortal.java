import java.util.*;
public class customerCarePortal {
	Scanner scanner = new Scanner(System.in);
	ArrayList<account> accounts = new ArrayList<>();
	ArrayList<accountHolder> accountHolders = new ArrayList<>();
	public customerCarePortal(ArrayList<account> accounts, ArrayList<accountHolder> accountHolders) {
		this.accounts = accounts;
		this.accountHolders = accountHolders;
		while(true) {
			System.out.println("");
			System.out.println("");
			System.out.println("***SIMBA Customer Care Portal***");
			System.out.println("");
			System.out.println("");
			System.out.println("Select operation:");
			System.out.println("1. Check balance");
			System.out.println("2. Make a deposit");
			System.out.println("3. Make a withdrawal");
			System.out.println("4. Transfer to account");
			System.out.println("5. Open a new account");
			System.out.println("6. Get account information");
			System.out.println("");
			char option = scanner.next().charAt(0);
			accounts = evaluateChoice(option);
			new fileIO().writeAccounts(accounts);
			new fileIO().writeAccountHolders(accountHolders);
		}
	}
	private ArrayList<account> evaluateChoice(char option) {
		if(option == '1') {
			System.out.print("Please Enter Username: ");
			String user = scanner.next();
			for (account account : accounts) {
				if(account.getUser().equals(user)) {
					System.out.println("Balance: "+account.getBalance());
					break;
				}
			}
			
		}
		else if(option == '2') {
			System.out.print("Please Enter Username: ");
			String user = scanner.next();
			System.out.print("Please Enter Amount: ");
			int amount = scanner.nextInt();
			for (account account : accounts) {
				if(account.getUser().equals(user)) {
					account.deposit(amount);
					System.out.println("New balance: "+account.getBalance());
					break;
				}
			}
		}
		else if(option == '3') {
			System.out.print("Please Enter Username: ");
			String user = scanner.next();
			System.out.print("Please Enter Amount: ");
			int amount = scanner.nextInt();
			for (account account : accounts) {
				if(account.getUser().equals(user)) {
					account.withdraw(amount);
					System.out.println("New balance: "+account.getBalance());
					break;
				}
			}
		}
		else if(option == '4') {
			account transferor_account = null;
			account transferee_account = null;
			System.out.print("Please Enter Username: ");
			String user = scanner.next();
			System.out.print("Please Enter Username of Transferee : ");
			String transferee = scanner.next();
			System.out.print("Please Enter Amount: ");
			int amount = scanner.nextInt();
			for (account account : accounts) {
				if(account.getUser().equals(user)) {
					transferor_account = account;
				}
				if(account.getUser().equals(transferee)) {
					transferee_account = account;
				}
				if (transferor_account != null && transferee_account != null) {
					break;
				}
			}
			if (transferor_account == null) {
				System.out.println("Transferor account does not exist.");
			}
			else if (transferee_account == null) {
				System.out.println("Transferee account does not exist.");
			}
			else {
				transferor_account.transfer(amount, transferee_account);
			}
		}
		else if(option == '5') {
			boolean user_exists_flag = false;
			boolean citizen_okay_flag = false;
			System.out.print("Please Enter Username: ");
			String user = scanner.next();
			
			for (account account : accounts) {
				if(account.getUser().equals(user)) {
					user_exists_flag = true;
					break;
				}
			}
			if (user_exists_flag == true) {
				System.out.println("This user name already exists. Please choose another name.");
				evaluateChoice('5');
			}
			else {
				System.out.print("Please Enter Citizenship Number: ");
				String citizenship_number = scanner.next();
				scanner.nextLine();
				System.out.print("Please Enter Full Name: ");
				String full_name = scanner.nextLine();
			
				for (accountHolder accountHolder : accountHolders) {
					if(accountHolder.getCitizenNumber().equals(citizenship_number)) {
						if(accountHolder.getName().equals(full_name)) {
							citizen_okay_flag = true;
							break;
						}
						else {
							System.out.println("The name provided does not match the corresponding name against citizenship number.");
							citizen_okay_flag = false;
							break;
							}
					}
					else {
						citizen_okay_flag = true;
					}
				}
				if(user_exists_flag == false && citizen_okay_flag == true) {
					accountHolder accountHolder = new accountHolder(user, full_name.split(" ")[0], full_name.split(" ")[1], citizenship_number);
					accountHolders.add(accountHolder);
					System.out.print("Please Enter Amount: ");
					int amount = scanner.nextInt();
					account account = new account(user, amount);
					accounts.add(account);
					System.out.println(user+"'s account created successfully.");
					}
				
				}
			}
		else if(option == '6') {
			System.out.print("Please Enter Citizenship Number: ");
			String citizenship_number = scanner.next();
			
			ArrayList<accountHolder> this_citizens_info = new ArrayList<>();
			
			for (accountHolder accountHolder : accountHolders) {
				if(accountHolder.getCitizenNumber().equals(citizenship_number)) {
					this_citizens_info.add(accountHolder);
				}
			}
			
			System.out.println("Account details for citizen number "+citizenship_number);
			
			if(this_citizens_info.size() > 0) {
				for (accountHolder this_citizen : this_citizens_info) {
					for (account account : accounts) {
						if(account.getUser().equals(this_citizen.getUser())) {
							System.out.println("Account: "+account.getUser()+"\t\t\tBalance: "+account.getBalance());
						}
					}
				}
			}
		}
	
		else {
			System.out.println("Invalid choice.");
		}
		return accounts;
	}
}	
	
