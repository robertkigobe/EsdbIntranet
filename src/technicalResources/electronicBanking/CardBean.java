package technicalResources.electronicBanking;

public class CardBean {

	String applicationDate;
	String branch;
	String title;
	String fname;
	String lname;
	String accountType;
	String accountTyped;
	String cif;
	String accountNumber;
	String nationId;
	String mobileNumber;
	String physicalAddress;
	String postalAdress;
	String telephoneNumber;
	String email;
	String cardTpe;
	// introduced 25th may 2018 to cater for reconciliation
	String branchCode;
	String printed;
	String printDate;
	String status;
	/////////////////////////
	String nameOnCard;
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getNationId() {
		return nationId;
	}
	public void setNationId(String nationId) {
		this.nationId = nationId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	public String getPostalAdress() {
		return postalAdress;
	}
	public void setPostalAdress(String postalAdress) {
		this.postalAdress = postalAdress;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCardTpe() {
		return cardTpe;
	}
	public void setCardTpe(String cardTpe) {
		this.cardTpe = cardTpe;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	
	public String getAccountTyped() {
		return accountTyped;
	}
	public void setAccountTyped(String accountTyped) {
		this.accountTyped = accountTyped;
	}
	
	
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getPrinted() {
		return printed;
	}
	public void setPrinted(String printed) {
		this.printed = printed;
	}
	public String getPrintDate() {
		return printDate;
	}
	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CardBean(String applicationDate, String branch, String title,
			String fname, String lname, String accountType,
			String accountTyped, String cif, String accountNumber,
			String nationId, String mobileNumber, String physicalAddress,
			String postalAdress, String telephoneNumber, String email,
			String cardTpe, String branchCode, String printed,
			String printDate, String status, String nameOnCard) {
		super();
		this.applicationDate = applicationDate;
		this.branch = branch;
		this.title = title;
		this.fname = fname;
		this.lname = lname;
		this.accountType = accountType;
		this.accountTyped = accountTyped;
		this.cif = cif;
		this.accountNumber = accountNumber;
		this.nationId = nationId;
		this.mobileNumber = mobileNumber;
		this.physicalAddress = physicalAddress;
		this.postalAdress = postalAdress;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.cardTpe = cardTpe;
		this.branchCode = branchCode;
		this.printed = printed;
		this.printDate = printDate;
		this.status = status;
		this.nameOnCard = nameOnCard;
	}
	@Override
	public String toString() {
		return "CardBean [applicationDate=" + applicationDate + ", branch="
				+ branch + ", title=" + title + ", fname=" + fname + ", lname="
				+ lname + ", accountType=" + accountType + ", accountTyped="
				+ accountTyped + ", cif=" + cif + ", accountNumber="
				+ accountNumber + ", nationId=" + nationId + ", mobileNumber="
				+ mobileNumber + ", physicalAddress=" + physicalAddress
				+ ", postalAdress=" + postalAdress + ", telephoneNumber="
				+ telephoneNumber + ", email=" + email + ", cardTpe=" + cardTpe
				+ ", branchCode=" + branchCode + ", printed=" + printed
				+ ", printDate=" + printDate + ", status=" + status
				+ ", nameOnCard=" + nameOnCard + "]";
	}
	
	
}
