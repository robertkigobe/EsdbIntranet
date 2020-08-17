package technicalResources.risk;

public class AmlBean {
	String year;
	String name;
	String branch;
	String department;
	int totalScore;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public AmlBean(String year, String name, String branch, String department,
			int totalScore) {
		super();
		this.year = year;
		this.name = name;
		this.branch = branch;
		this.department = department;
		this.totalScore = totalScore;
	}
	
	

}
