package technicalResources.bsc;

public class BscReportsAnnualsubmissionBean {
	
	
	
	
	String bscEmployeeName;
	String subDepartment;
	public String getBscEmployeeName() {
		return bscEmployeeName;
	}
	public void setBscEmployeeName(String bscEmployeeName) {
		this.bscEmployeeName = bscEmployeeName;
	}
	public String getSubDepartment() {
		return subDepartment;
	}
	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}
	public BscReportsAnnualsubmissionBean(String bscEmployeeName,
			String subDepartment) {
		super();
		this.bscEmployeeName = bscEmployeeName;
		this.subDepartment = subDepartment;
	}
	
	
	
}
