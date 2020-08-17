package technicalResources.electronicBanking;

public class MukuruMonthlyCustomerBean {

	String branch;
	String snap_shot;
	String recipient;
	String recipient_ID;
	int total_count;
	float total_ordered;
	float total_received;
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSnap_shot() {
		return snap_shot;
	}
	public void setSnap_shot(String snap_shot) {
		this.snap_shot = snap_shot;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getRecipient_ID() {
		return recipient_ID;
	}
	public void setRecipient_ID(String recipient_ID) {
		this.recipient_ID = recipient_ID;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public float getTotal_ordered() {
		return total_ordered;
	}
	public void setTotal_ordered(float total_ordered) {
		this.total_ordered = total_ordered;
	}
	public float getTotal_received() {
		return total_received;
	}
	public void setTotal_received(float total_received) {
		this.total_received = total_received;
	}
	public MukuruMonthlyCustomerBean(String branch, String snap_shot,
			String recipient, String recipient_ID, int total_count,
			float total_ordered, float total_received) {
		super();
		this.branch = branch;
		this.snap_shot = snap_shot;
		this.recipient = recipient;
		this.recipient_ID = recipient_ID;
		this.total_count = total_count;
		this.total_ordered = total_ordered;
		this.total_received = total_received;
	}
	@Override
	public String toString() {
		return "MukuruMonthlyCustomerBean [branch=" + branch + ", snap_shot="
				+ snap_shot + ", recipient=" + recipient + ", recipient_ID="
				+ recipient_ID + ", total_count=" + total_count
				+ ", total_ordered=" + total_ordered + ", total_received="
				+ total_received + "]";
	}
	
		
}
