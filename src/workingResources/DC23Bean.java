package workingResources;

public class DC23Bean {
	
	String id;
    String accountnumber;
    String sign;
    String amountlcy;
    String narrative;
    String valuedate;
    String inputter;
    String authoriser;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getAmountlcy() {
		return amountlcy;
	}
	public void setAmountlcy(String amountlcy) {
		this.amountlcy = amountlcy;
	}
	public String getNarrative() {
		return narrative;
	}
	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}
	public String getValuedate() {
		return valuedate;
	}
	public void setValuedate(String valuedate) {
		this.valuedate = valuedate;
	}
	public String getInputter() {
		return inputter;
	}
	public void setInputter(String inputter) {
		this.inputter = inputter;
	}
	public String getAuthoriser() {
		return authoriser;
	}
	public void setAuthoriser(String authoriser) {
		this.authoriser = authoriser;
	}
	public DC23Bean(String id, String accountnumber, String sign,
			String amountlcy, String narrative, String valuedate,
			String inputter, String authoriser) {
		super();
		this.id = id;
		this.accountnumber = accountnumber;
		this.sign = sign;
		this.amountlcy = amountlcy;
		this.narrative = narrative;
		this.valuedate = valuedate;
		this.inputter = inputter;
		this.authoriser = authoriser;
	}

    


}
