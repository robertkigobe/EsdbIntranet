package technicalResources.SkillsAudits;

public class SkillsAuditReportBean {
	
	String subDepartment;
	String position;
	String category;
	String skill;
	String bscEmployeeName;
	String bscEmployeeSupervisor;
	String rating;
	String priority;
	String remarks;

	public String getSubDepartment() {
		return subDepartment;
	}

	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getBscEmployeeName() {
		return bscEmployeeName;
	}

	public void setBscEmployeeName(String bscEmployeeName) {
		this.bscEmployeeName = bscEmployeeName;
	}

	public String getBscEmployeeSupervisor() {
		return bscEmployeeSupervisor;
	}

	public void setBscEmployeeSupervisor(String bscEmployeeSupervisor) {
		this.bscEmployeeSupervisor = bscEmployeeSupervisor;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public SkillsAuditReportBean(String subDepartment, String position,
			String category, String skill, String bscEmployeeName,
			String bscEmployeeSupervisor, String rating, String priority,
			String remarks) {
		super();
		this.subDepartment = subDepartment;
		this.position = position;
		this.category = category;
		this.skill = skill;
		this.bscEmployeeName = bscEmployeeName;
		this.bscEmployeeSupervisor = bscEmployeeSupervisor;
		this.rating = rating;
		this.priority = priority;
		this.remarks = remarks;
	}

}
