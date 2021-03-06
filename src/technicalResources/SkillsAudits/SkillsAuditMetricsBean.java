package technicalResources.SkillsAudits;

public class SkillsAuditMetricsBean {

	String financialYear;
	String department;
	String subDepartment;
	String position;
	String category;
	String skill;
	String rating;
	String priority;
	String remarks;
	public String getFinancialYear() {
		return financialYear;
	}
	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
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
	public SkillsAuditMetricsBean(String financialYear, String department,
			String subDepartment, String position, String category,
			String skill, String rating, String priority, String remarks) {
		super();
		this.financialYear = financialYear;
		this.department = department;
		this.subDepartment = subDepartment;
		this.position = position;
		this.category = category;
		this.skill = skill;
		this.rating = rating;
		this.priority = priority;
		this.remarks = remarks;
	}

}
