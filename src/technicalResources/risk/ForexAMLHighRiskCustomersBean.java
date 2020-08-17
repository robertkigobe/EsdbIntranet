package technicalResources.risk;

public class ForexAMLHighRiskCustomersBean {
	
	String transactionDate,cif,customerName,branch,currency,destination,transactions, totalAmount;

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	

	public String getTransactions() {
		return transactions;
	}

	public void setTransactions(String transactions) {
		transactions = transactions;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public ForexAMLHighRiskCustomersBean(String transactionDate, String cif,
			String customerName, String branch, String currency,
			String destination,  String transactions,
			String totalAmount) {
		super();
		this.transactionDate = transactionDate;
		this.cif = cif;
		this.customerName = customerName;
		this.branch = branch;
		this.currency = currency;
		this.destination = destination;
		transactions = transactions;
		this.totalAmount = totalAmount;
	}

	
}
