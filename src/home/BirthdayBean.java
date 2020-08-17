package home;

public class BirthdayBean {
	
	String firstname;
	String surname;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public BirthdayBean(String firstname, String surname) {
		super();
		this.firstname = firstname;
		this.surname = surname;
	}
	
	

}
