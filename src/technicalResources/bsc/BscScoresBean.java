package technicalResources.bsc;

public class BscScoresBean {
	String objectivePeriod;
	String bscPeriod;
	String bscTargetSettingDate;
	String bscDate;
	String bscEmployeeName;
	String bscEmployeeSupervisor;
	String department;
	String  position;
	String rolePlayed;
	String perspective;
	String objective;
	String period;
	String reportingFrequency;
	String measure;
	float base;
	float stretch;
	float actual;
	public String getObjectivePeriod() {
		return objectivePeriod;
	}
	public void setObjectivePeriod(String objectivePeriod) {
		this.objectivePeriod = objectivePeriod;
	}
	public String getBscPeriod() {
		return bscPeriod;
	}
	public void setBscPeriod(String bscPeriod) {
		this.bscPeriod = bscPeriod;
	}
	public String getBscTargetSettingDate() {
		return bscTargetSettingDate;
	}
	public void setBscTargetSettingDate(String bscTargetSettingDate) {
		this.bscTargetSettingDate = bscTargetSettingDate;
	}
	public String getBscDate() {
		return bscDate;
	}
	public void setBscDate(String bscDate) {
		this.bscDate = bscDate;
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
	public float getActual() {
		return actual;
	}
	public void setActual(float actual) {
		this.actual = actual;
	}
	public BscScoresBean(String objectivePeriod, String bscPeriod,
			String bscTargetSettingDate, String bscDate,
			String bscEmployeeName, String bscEmployeeSupervisor,
			String department, String position, String rolePlayed,
			String perspective, String objective, String period,
			String reportingFrequency, String measure, float base,
			float stretch, float actual) {
		super();
		this.objectivePeriod = objectivePeriod;
		this.bscPeriod = bscPeriod;
		this.bscTargetSettingDate = bscTargetSettingDate;
		this.bscDate = bscDate;
		this.bscEmployeeName = bscEmployeeName;
		this.bscEmployeeSupervisor = bscEmployeeSupervisor;
		this.department = department;
		this.position = position;
		this.rolePlayed = rolePlayed;
		this.perspective = perspective;
		this.objective = objective;
		this.period = period;
		this.reportingFrequency = reportingFrequency;
		this.measure = measure;
		this.base = base;
		this.stretch = stretch;
		this.actual = actual;
	}

	
}
