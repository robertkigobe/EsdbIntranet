package technicalResources.staffLoan;



public class LoanBeanCustomerResume {

	String loanRef;
	String status;
	String dateCreated;
	String branch;
	String nationalID;
	String applicantName;
	String dob;
	String accountNumber;
	String postalAddress;
	String city;
	String mobileNumber;
	String currentEmployer;
	String loanType;
	String loanDuration;
	float loanAmountRequested;
	float grossPay;
	float totalDecuctions;
	String createdBy;
	
	public String getLoanRef() {
		return loanRef;
	}
	public void setLoanRef(String loanRef) {
		this.loanRef = loanRef;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getNationalID() {
		return nationalID;
	}
	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCurrentEmployer() {
		return currentEmployer;
	}
	public void setCurrentEmployer(String currentEmployer) {
		this.currentEmployer = currentEmployer;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getLoanDuration() {
		return loanDuration;
	}
	public void setLoanDuration(String loanDuration) {
		this.loanDuration = loanDuration;
	}
	public float getLoanAmountRequested() {
		return loanAmountRequested;
	}
	public void setLoanAmountRequested(float loanAmountRequested) {
		this.loanAmountRequested = loanAmountRequested;
	}
	public float getGrossPay() {
		return grossPay;
	}
	public void setGrossPay(float grossPay) {
		this.grossPay = grossPay;
	}
	public float getTotalDecuctions() {
		return totalDecuctions;
	}
	public void setTotalDecuctions(float totalDecuctions) {
		this.totalDecuctions = totalDecuctions;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LoanBeanCustomerResume(String loanRef, String status,
			String dateCreated, String branch, String nationalID,
			String applicantName, String dob, String accountNumber,
			String postalAddress, String city, String mobileNumber,
			String currentEmployer, String loanType, String loanDuration,
			float loanAmountRequested, float grossPay, float totalDecuctions,
			String createdBy) {
		super();
		this.loanRef = loanRef;
		this.status = status;
		this.dateCreated = dateCreated;
		this.branch = branch;
		this.nationalID = nationalID;
		this.applicantName = applicantName;
		this.dob = dob;
		this.accountNumber = accountNumber;
		this.postalAddress = postalAddress;
		this.city = city;
		this.mobileNumber = mobileNumber;
		this.currentEmployer = currentEmployer;
		this.loanType = loanType;
		this.loanDuration = loanDuration;
		this.loanAmountRequested = loanAmountRequested;
		this.grossPay = grossPay;
		this.totalDecuctions = totalDecuctions;
		this.createdBy = createdBy;
	}
	
	


}
