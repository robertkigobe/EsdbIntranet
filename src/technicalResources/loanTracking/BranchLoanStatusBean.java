package technicalResources.loanTracking;

public class BranchLoanStatusBean {
	
	float loanAmount = 0;
	String applicantName = null;
	String inactivity = null;
	String loanStatus = null;
	String lastModifiedDate = null;
	String iDNumber = null;
	String loanReference = null;
	public float getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getInactivity() {
		return inactivity;
	}
	public void setInactivity(String inactivity) {
		this.inactivity = inactivity;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getiDNumber() {
		return iDNumber;
	}
	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}
	public String getLoanReference() {
		return loanReference;
	}
	public void setLoanReference(String loanReference) {
		this.loanReference = loanReference;
	}
	public BranchLoanStatusBean(float loanAmount, String applicantName,
			String inactivity, String loanStatus, String lastModifiedDate,
			String iDNumber, String loanReference) {
		super();
		this.loanAmount = loanAmount;
		this.applicantName = applicantName;
		this.inactivity = inactivity;
		this.loanStatus = loanStatus;
		this.lastModifiedDate = lastModifiedDate;
		this.iDNumber = iDNumber;
		this.loanReference = loanReference;
	}
	
		
}
