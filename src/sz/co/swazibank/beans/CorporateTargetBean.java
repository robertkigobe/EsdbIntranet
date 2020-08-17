package sz.co.swazibank.beans;

import java.sql.Date;

public class CorporateTargetBean {
	
	private String perspective;// = request.getParameter("perspective");
	private String objective;// = request.getParameter("objective");
	private String measure;// = request.getParameter("measure");
	private String period;// = request.getParameter("ST");
	private String frequency;// = request.getParameter("RF");
	private String base;// = request.getParameter("base");
	private String stretch;// = request.getParameter("stretch");
	private String remarks;// = request.getParameter("remarks");
	private Date startDate;
	private Date endDate;
	public CorporateTargetBean(String perspective, String objective,
			String measure, String period, String frequency, String base,
			String stretch, String remarks, Date startDate, Date endDate) {
		super();
		this.perspective = perspective;
		this.objective = objective;
		this.measure = measure;
		this.period = period;
		this.frequency = frequency;
		this.base = base;
		this.stretch = stretch;
		this.remarks = remarks;
		this.startDate = startDate;
		this.endDate = endDate;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	

}
