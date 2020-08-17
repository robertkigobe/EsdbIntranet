package technicalResources.IT;

public class ITDashboardBean {
	
	private int day;
	private int month;
	private int year;
	private float amount;
	
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public ITDashboardBean(int day, int month, int year, float amount) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return  day + "," + month + "," + year + "," + amount ;
	}
	
	
	
	

}
