package technicalResources.electronicBanking;

public class MukuruCustomerBean {

	float Sheet_Ref;
	String Branch;
	String Teller;
	String Recipient;
	String Recipient_ID;
	float Order;
	String Order_Confirmed_Date;
	String Order_Completed_Date;
	float Ordered_SZL;
	float Issued_SZL;
	public float getSheet_Ref() {
		return Sheet_Ref;
	}
	public void setSheet_Ref(float sheet_Ref) {
		Sheet_Ref = sheet_Ref;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getTeller() {
		return Teller;
	}
	public void setTeller(String teller) {
		Teller = teller;
	}
	public String getRecipient() {
		return Recipient;
	}
	public void setRecipient(String recipient) {
		Recipient = recipient;
	}
	public String getRecipient_ID() {
		return Recipient_ID;
	}
	public void setRecipient_ID(String recipient_ID) {
		Recipient_ID = recipient_ID;
	}
	public float getOrder() {
		return Order;
	}
	public void setOrder(float order) {
		Order = order;
	}
	public String getOrder_Confirmed_Date() {
		return Order_Confirmed_Date;
	}
	public void setOrder_Confirmed_Date(String order_Confirmed_Date) {
		Order_Confirmed_Date = order_Confirmed_Date;
	}
	public String getOrder_Completed_Date() {
		return Order_Completed_Date;
	}
	public void setOrder_Completed_Date(String order_Completed_Date) {
		Order_Completed_Date = order_Completed_Date;
	}
	public float getOrdered_SZL() {
		return Ordered_SZL;
	}
	public void setOrdered_SZL(float ordered_SZL) {
		Ordered_SZL = ordered_SZL;
	}
	public float getIssued_SZL() {
		return Issued_SZL;
	}
	public void setIssued_SZL(float issued_SZL) {
		Issued_SZL = issued_SZL;
	}
	public MukuruCustomerBean(float sheet_Ref, String branch, String teller,
			String recipient, String recipient_ID, float order,
			String order_Confirmed_Date, String order_Completed_Date,
			float ordered_SZL, float issued_SZL) {
		super();
		Sheet_Ref = sheet_Ref;
		Branch = branch;
		Teller = teller;
		Recipient = recipient;
		Recipient_ID = recipient_ID;
		Order = order;
		Order_Confirmed_Date = order_Confirmed_Date;
		Order_Completed_Date = order_Completed_Date;
		Ordered_SZL = ordered_SZL;
		Issued_SZL = issued_SZL;
	}
	
	@Override
	public String toString() {
		return "MukuruCustomerBean [Sheet_Ref=" + Sheet_Ref + ", Branch="
				+ Branch + ", Teller=" + Teller + ", Recipient=" + Recipient
				+ ", Recipient_ID=" + Recipient_ID + ", Order=" + Order
				+ ", Order_Confirmed_Date=" + Order_Confirmed_Date
				+ ", Order_Completed_Date=" + Order_Completed_Date
				+ ", Ordered_SZL=" + Ordered_SZL + ", Issued_SZL=" + Issued_SZL
				+ "]";
	}
	
		

}
