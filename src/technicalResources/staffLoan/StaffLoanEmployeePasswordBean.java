package technicalResources.staffLoan;

public class StaffLoanEmployeePasswordBean {
	
	String  employeeCode;
	String  title;
	String  surName;
	String  firstName;
	String  password;
	String  department;
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public StaffLoanEmployeePasswordBean(String employeeCode, String title,
			String surName, String firstName, String password, String department) {
		super();
		this.employeeCode = employeeCode;
		this.title = title;
		this.surName = surName;
		this.firstName = firstName;
		this.password = password;
		this.department = department;
	}
	
	
}
