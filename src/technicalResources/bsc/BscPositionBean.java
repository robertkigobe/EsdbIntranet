package technicalResources.bsc;

public class BscPositionBean {
	String department;
	String position;
	String rolePlayed;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getRolePlayed() {
		return rolePlayed;
	}
	public void setRolePlayed(String rolePlayed) {
		this.rolePlayed = rolePlayed;
	}
	public BscPositionBean(String department, String position, String rolePlayed) {
		super();
		this.department = department;
		this.position = position;
		this.rolePlayed = rolePlayed;
	}
	
	

}
