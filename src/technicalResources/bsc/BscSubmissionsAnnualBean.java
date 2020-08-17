package technicalResources.bsc;

public class BscSubmissionsAnnualBean {
	

	String subDepartment;
	String bscEmployeeName;
	float averageScore;
	String status;
	public String getSubDepartment() {
		return subDepartment;
	}
	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}
	public String getBscEmployeeName() {
		return bscEmployeeName;
	}
	public void setBscEmployeeName(String bscEmployeeName) {
		this.bscEmployeeName = bscEmployeeName;
	}
	public float getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BscSubmissionsAnnualBean(String subDepartment,
			String bscEmployeeName, float averageScore, String status) {
		super();
		this.subDepartment = subDepartment;
		this.bscEmployeeName = bscEmployeeName;
		this.averageScore = averageScore;
		this.status = status;
	}
	
	
		
}
