
public class accountHolder {

	private String first_name;
	private String surname;
	private String user;
	private String citizenship_number;
	
	public accountHolder(String user, String first_name, String surname, String citizenship_number) {
		this.first_name = first_name;
		this.surname = surname;
		this.citizenship_number= citizenship_number;
		this.user = user;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public String getName() {
		return this.first_name + " " + this.surname;
	}
	
	public String getCitizenNumber() {
		return this.citizenship_number;
	}
}
