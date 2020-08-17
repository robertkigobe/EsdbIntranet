package technicalResources.bsc;

public class BscSubmissionsBean {
	
	String bscPeriodSubmission;
	String subDepartment;
	String bscEmployeeNameSubmission;
	String bscEmployeeSupervisorSubmission;
	String positionSubmission;
	
	
	public String getBscPeriodSubmission() {
		return bscPeriodSubmission;
	}
	public void setBscPeriodSubmission(String bscPeriodSubmission) {
		this.bscPeriodSubmission = bscPeriodSubmission;
	}
	public String getBscEmployeeNameSubmission() {
		return bscEmployeeNameSubmission;
	}
	public void setBscEmployeeNameSubmission(String bscEmployeeNameSubmission) {
		this.bscEmployeeNameSubmission = bscEmployeeNameSubmission;
	}
	public String getBscEmployeeSupervisorSubmission() {
		return bscEmployeeSupervisorSubmission;
	}
	public void setBscEmployeeSupervisorSubmission(
			String bscEmployeeSupervisorSubmission) {
		this.bscEmployeeSupervisorSubmission = bscEmployeeSupervisorSubmission;
	}
	public String getPositionSubmission() {
		return positionSubmission;
	}
	public void setPositionSubmission(String positionSubmission) {
		this.positionSubmission = positionSubmission;
	}
	public String getSubDepartment() {
		return subDepartment;
	}
	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}
	public BscSubmissionsBean(String bscPeriodSubmission, String subDepartment,
			String bscEmployeeNameSubmission,
			String bscEmployeeSupervisorSubmission, String positionSubmission) {
		super();
		this.bscPeriodSubmission = bscPeriodSubmission;
		this.subDepartment = subDepartment;
		this.bscEmployeeNameSubmission = bscEmployeeNameSubmission;
		this.bscEmployeeSupervisorSubmission = bscEmployeeSupervisorSubmission;
		this.positionSubmission = positionSubmission;
	}
	

	
}
