import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class fileIO {

	public ArrayList<account> readAccounts(){
		ArrayList<account> accounts = new ArrayList<>();
		try {
			BufferedReader buffered_reader = new BufferedReader(new FileReader("accounts.txt"));
			String line;
			while((line = buffered_reader.readLine()) != null) {
				account account = new account(line.split("/")[0], Integer.parseInt(line.split("/")[1]));
				accounts.add(account);
			}
			buffered_reader.close();
		}
		catch(Exception exception) {
			System.out.println(exception);
			
		}
		return accounts;
	}
	
	public void writeAccounts(ArrayList<account> accounts){
		try {
			BufferedWriter buffered_writer = new BufferedWriter(new FileWriter("accounts.txt"));
			for (account account : accounts) {
				buffered_writer.write(account.getUser() + "/" + account.getBalance() + "\n");
			}
			buffered_writer.close();
		}
		catch(Exception exception) {
			System.out.println(exception);
			
		}
	}
	
	public ArrayList<accountHolder> readAccountHolders(){
		ArrayList<accountHolder> accountHolders = new ArrayList<>();
		try {
			BufferedReader buffered_reader = new BufferedReader(new FileReader("accountHolders.txt"));
			String line;
			while((line = buffered_reader.readLine()) != null) {
				accountHolder accountHolder = new accountHolder(line.split("/")[0], line.split("/")[1], line.split("/")[2], line.split("/")[3]);
				accountHolders.add(accountHolder);
			}
			buffered_reader.close();
		}
		catch(Exception exception) {
			System.out.println(exception);
			
		}
		return accountHolders;
	}
	
	public void writeAccountHolders(ArrayList<accountHolder> accountHolders){
		try {
			BufferedWriter buffered_writer = new BufferedWriter(new FileWriter("accountHolders.txt"));
			for (accountHolder accountHolder : accountHolders) {
				buffered_writer.write(accountHolder.getUser() + "/" + accountHolder.getName().split(" ")[0] + 
						"/" + accountHolder.getName().split(" ")[1] + "/" + 
						accountHolder.getCitizenNumber() + "\n");
			}
			buffered_writer.close();
		}
		catch(Exception exception) {
			System.out.println(exception);
			
		}
	}
}
