package technicalResources.bsc;

public class BscReportsSearchBean {
	
	String bscPeriod;
	String department; 
	String subDepartment; 
	String position;
	String bscEmployeeName;
	String bscEmployeeSupervisor; 
	String perspective;
	String objective;
	String period;
	String reportingFrequencies;
	String measure;
	float base;
	float stretch;
	float actual;
	float archievementRatio;		
	float totalScore;
	float averageScore;
	String status;
	public String getSubDepartment() {
		return subDepartment;
	}
	public void setSubDepartment(String subDepartment) {
		this.subDepartment = subDepartment;
	}
	public String getBscPeriod() {
		return bscPeriod;
	}
	public void setBscPeriod(String bscPeriod) {
		this.bscPeriod = bscPeriod;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBscEmployeeSupervisor() {
		return bscEmployeeSupervisor;
	}
	public void setBscEmployeeSupervisor(String bscEmployeeSupervisor) {
		this.bscEmployeeSupervisor = bscEmployeeSupervisor;
	}
	public String getBscEmployeeName() {
		return bscEmployeeName;
	}
	public void setBscEmployeeName(String bscEmployeeName) {
		this.bscEmployeeName = bscEmployeeName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
	public String getReportingFrequencies() {
		return reportingFrequencies;
	}
	public void setReportingFrequencies(String reportingFrequencies) {
		this.reportingFrequencies = reportingFrequencies;
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
	public float getArchievementRatio() {
		return archievementRatio;
	}
	public void setArchievementRatio(float archievementRatio) {
		this.archievementRatio = archievementRatio;
	}
	public float getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}
	public float getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public BscReportsSearchBean(String subDepartment, String bscPeriod,
			String department, String bscEmployeeSupervisor,
			String bscEmployeeName, String position, String perspective,
			String objective, String period, String reportingFrequencies,
			String measure, float base, float stretch, float actual,
			float archievementRatio, float totalScore, float averageScore,
			String status) {
		super();
		this.subDepartment = subDepartment;
		this.bscPeriod = bscPeriod;
		this.department = department;
		this.bscEmployeeSupervisor = bscEmployeeSupervisor;
		this.bscEmployeeName = bscEmployeeName;
		this.position = position;
		this.perspective = perspective;
		this.objective = objective;
		this.period = period;
		this.reportingFrequencies = reportingFrequencies;
		this.measure = measure;
		this.base = base;
		this.stretch = stretch;
		this.actual = actual;
		this.archievementRatio = archievementRatio;
		this.totalScore = totalScore;
		this.averageScore = averageScore;
		this.status = status;
	}
	
	
	
	
	
}
