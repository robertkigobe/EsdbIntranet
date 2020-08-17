package technicalResources.risk;

public class ForexAMLRiskDailyBean {
	
	String transactionDate, customerName,  branch , currency, amount , destination , cif ;

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public ForexAMLRiskDailyBean(String transactionDate, String customerName,
			String branch, String currency, String amount, String destination,
			String cif) {
		super();
		this.transactionDate = transactionDate;
		this.customerName = customerName;
		this.branch = branch;
		this.currency = currency;
		this.amount = amount;
		this.destination = destination;
		this.cif = cif;
	}
	
	
}
