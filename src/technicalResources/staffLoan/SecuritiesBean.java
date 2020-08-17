package technicalResources.staffLoan;

public class SecuritiesBean {
	
	String loanRef;
	String securitiesPrinted;
	public String getLoanRef() {
		return loanRef;
	}
	public void setLoanRef(String loanRef) {
		this.loanRef = loanRef;
	}
	public String getSecuritiesPrinted() {
		return securitiesPrinted;
	}
	public void setSecuritiesPrinted(String securitiesPrinted) {
		this.securitiesPrinted = securitiesPrinted;
	}
	public SecuritiesBean(String loanRef, String securitiesPrinted) {
		super();
		this.loanRef = loanRef;
		this.securitiesPrinted = securitiesPrinted;
	}
	
	
}
