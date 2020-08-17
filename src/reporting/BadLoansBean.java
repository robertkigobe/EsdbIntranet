package reporting;

public class BadLoansBean {
	
	String year;
	String accNo;
	String cif;
	String nationalId;
	String dept;
	String type;
	String customer;
	String currentBalance;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}
	public BadLoansBean(String year, String accNo, String cif,
			String nationalId, String dept, String type, String customer,
			String currentBalance) {
		super();
		this.year = year;
		this.accNo = accNo;
		this.cif = cif;
		this.nationalId = nationalId;
		this.dept = dept;
		this.type = type;
		this.customer = customer;
		this.currentBalance = currentBalance;
	}
	
}
