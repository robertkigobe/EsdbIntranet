package technicalResources.staffLoan;

public class StaffLoanStatusBean {
	
	String loanRef;
	String inactivity;
	String currentStatus;
	String lastModifiedDate;
	String lastModifiedBy;
	public String getLoanRef() {
		return loanRef;
	}
	public void setLoanRef(String loanRef) {
		this.loanRef = loanRef;
	}
	public String getInactivity() {
		return inactivity;
	}
	public void setInactivity(String inactivity) {
		this.inactivity = inactivity;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public StaffLoanStatusBean(String loanRef, String inactivity,
			String currentStatus, String lastModifiedDate, String lastModifiedBy) {
		super();
		this.loanRef = loanRef;
		this.inactivity = inactivity;
		this.currentStatus = currentStatus;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedBy = lastModifiedBy;
	}
	
	

}
