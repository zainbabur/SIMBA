
public class main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			new customerCarePortal(new fileIO().readAccounts(), new fileIO().readAccountHolders());
			}
	}
}
