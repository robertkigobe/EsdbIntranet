package reporting;

public class ProvisionBean {
	String year;
	String quater;
	String accNo;
	String contractIds;
	String drawdownLink;
	String branch;
	String dept;
	String customer;
	String type;
	String yearEndBalance;
	String yearEndRate;
	String yearEndProvision;
	String currentBalance;
	String currentRate;
	String security;
	String currentProvisions;
	String pastDues;
	String comments;
	String oldAccount;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getQuater() {
		return quater;
	}
	public void setQuater(String quater) {
		this.quater = quater;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getContractIds() {
		return contractIds;
	}
	public void setContractIds(String contractIds) {
		this.contractIds = contractIds;
	}
	public String getDrawdownLink() {
		return drawdownLink;
	}
	public void setDrawdownLink(String drawdownLink) {
		this.drawdownLink = drawdownLink;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYearEndBalance() {
		return yearEndBalance;
	}
	public void setYearEndBalance(String yearEndBalance) {
		this.yearEndBalance = yearEndBalance;
	}
	public String getYearEndRate() {
		return yearEndRate;
	}
	public void setYearEndRate(String yearEndRate) {
		this.yearEndRate = yearEndRate;
	}
	public String getYearEndProvision() {
		return yearEndProvision;
	}
	public void setYearEndProvision(String yearEndProvision) {
		this.yearEndProvision = yearEndProvision;
	}
	public String getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getCurrentRate() {
		return currentRate;
	}
	public void setCurrentRate(String currentRate) {
		this.currentRate = currentRate;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getCurrentProvisions() {
		return currentProvisions;
	}
	public void setCurrentProvisions(String currentProvisions) {
		this.currentProvisions = currentProvisions;
	}
	public String getPastDues() {
		return pastDues;
	}
	public void setPastDues(String pastDues) {
		this.pastDues = pastDues;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getOldAccount() {
		return oldAccount;
	}
	public void setOldAccount(String oldAccount) {
		this.oldAccount = oldAccount;
	}
	public ProvisionBean(String year, String quater, String accNo,
			String contractIds, String drawdownLink, String branch,
			String dept, String customer, String type, String yearEndBalance,
			String yearEndRate, String yearEndProvision, String currentBalance,
			String currentRate, String security, String currentProvisions,
			String pastDues, String comments, String oldAccount) {
		super();
		this.year = year;
		this.quater = quater;
		this.accNo = accNo;
		this.contractIds = contractIds;
		this.drawdownLink = drawdownLink;
		this.branch = branch;
		this.dept = dept;
		this.customer = customer;
		this.type = type;
		this.yearEndBalance = yearEndBalance;
		this.yearEndRate = yearEndRate;
		this.yearEndProvision = yearEndProvision;
		this.currentBalance = currentBalance;
		this.currentRate = currentRate;
		this.security = security;
		this.currentProvisions = currentProvisions;
		this.pastDues = pastDues;
		this.comments = comments;
		this.oldAccount = oldAccount;
	}
	
	
	

}
