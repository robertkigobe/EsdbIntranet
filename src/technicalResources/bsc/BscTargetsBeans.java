package technicalResources.bsc;

public class BscTargetsBeans {
	
	String  position;
	String objectivePeriod;
	
	String department;	
	String rolePlayed;
	String perspective;
	String objective;
	String period;
	String reportingFrequency;
	String measure;
	
	float base;
	float stretch;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getObjectivePeriod() {
		return objectivePeriod;
	}
	public void setObjectivePeriod(String objectivePeriod) {
		this.objectivePeriod = objectivePeriod;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRolePlayed() {
		return rolePlayed;
	}
	public void setRolePlayed(String rolePlayed) {
		this.rolePlayed = rolePlayed;
	}
	public String getPerspective() {
		return perspective;
	}
	public void setPerspective(String perspective) {
		this.perspective = perspective;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getReportingFrequency() {
		return reportingFrequency;
	}
	public void setReportingFrequency(String reportingFrequency) {
		this.reportingFrequency = reportingFrequency;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	
	public float getBase() {
		return base;
	}
	public void setBase(float base) {
		this.base = base;
	}
	public float getStretch() {
		return stretch;
	}
	public void setStretch(float stretch) {
		this.stretch = stretch;
	}
	public BscTargetsBeans(String position, String objectivePeriod,
			String department, String rolePlayed,
			String perspective, String objective, String period,
			String reportingFrequency, String measure, 
			float base, float stretch) {
		super();
		this.position = position;
		this.objectivePeriod = objectivePeriod;
		this.department = department;
		this.rolePlayed = rolePlayed;
		this.perspective = perspective;
		this.objective = objective;
		this.period = period;
		this.reportingFrequency = reportingFrequency;
		this.measure = measure;
		this.base = base;
		this.stretch = stretch;
	}
	
	
}
