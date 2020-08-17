package technicalResources.risk;

public class RiskManagementSurveyBean {

	String employeeName;
	String subDepartment;
	String score;
	public RiskManagementSurveyBean(String employeeName, String subDepartment,
			String score) {
		super();
		this.employeeName = employeeName;
		this.subDepartment = subDepartment;
		this.score = score;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getSubDepartment() {
		return subDepartment;
	}
	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	

}
