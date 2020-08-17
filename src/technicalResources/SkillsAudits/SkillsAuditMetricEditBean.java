package technicalResources.SkillsAudits;

public class SkillsAuditMetricEditBean {

	String category;
	String skill;
	String rating;
	String priority;
	String remarks;

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

	public SkillsAuditMetricEditBean(String category, String skill,
			String rating, String priority, String remarks) {
		super();
		this.category = category;
		this.skill = skill;
		this.rating = rating;
		this.priority = priority;
		this.remarks = remarks;
	}

}
