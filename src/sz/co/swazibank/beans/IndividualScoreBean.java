package sz.co.swazibank.beans;

public class IndividualScoreBean {
	

	private String submissionDateStr;
	private String startDateStr;
	private String endDateStr;
	private String userName;
	private String department;
	private String subDepartment;
	private String supervisor;
	private String em;
	private String perspective;
	private String objective;
	private String measure;
	private String period;
	private String frequency;
	private String base;
	private String stretch;
	private String actual;
	private String remarks;
	public String getSubmissionDateStr() {
		return submissionDateStr;
	}
	public void setSubmissionDateStr(String submissionDateStr) {
		this.submissionDateStr = submissionDateStr;
	}
	public String getStartDateStr() {
		return startDateStr;
	}
	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}
	public String getEndDateStr() {
		return endDateStr;
	}
	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getEm() {
		return em;
	}
	public void setEm(String em) {
		this.em = em;
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
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getStretch() {
		return stretch;
	}
	public void setStretch(String stretch) {
		this.stretch = stretch;
	}
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public IndividualScoreBean(String submissionDateStr, String startDateStr,
			String endDateStr, String userName, String department,
			String subDepartment, String supervisor, String em,
			String perspective, String objective, String measure,
			String period, String frequency, String base, String stretch,
			String actual, String remarks) {
		super();
		this.submissionDateStr = submissionDateStr;
		this.startDateStr = startDateStr;
		this.endDateStr = endDateStr;
		this.userName = userName;
		this.department = department;
		this.subDepartment = subDepartment;
		this.supervisor = supervisor;
		this.em = em;
		this.perspective = perspective;
		this.objective = objective;
		this.measure = measure;
		this.period = period;
		this.frequency = frequency;
		this.base = base;
		this.stretch = stretch;
		this.actual = actual;
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "IndividualScoreBean [submissionDateStr=" + submissionDateStr
				+ ", startDateStr=" + startDateStr + ", endDateStr="
				+ endDateStr + ", userName=" + userName + ", department="
				+ department + ", subDepartment=" + subDepartment
				+ ", supervisor=" + supervisor + ", em=" + em
				+ ", perspective=" + perspective + ", objective=" + objective
				+ ", measure=" + measure + ", period=" + period
				+ ", frequency=" + frequency + ", base=" + base + ", stretch="
				+ stretch + ", actual=" + actual + ", remarks=" + remarks + "]";
	}
	
	
	
}
