package technicalResources.staffLoan;

public class StaffLoanSupervisorCommentsBean {
	
	String loanRef;
	
	String applicantName;

	public String getLoanRef() {
		return loanRef;
	}

	public void setLoanRef(String loanRef) {
		this.loanRef = loanRef;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public StaffLoanSupervisorCommentsBean(String loanRef, String applicantName) {
		super();
		this.loanRef = loanRef;
		this.applicantName = applicantName;
	}
	
	

}
