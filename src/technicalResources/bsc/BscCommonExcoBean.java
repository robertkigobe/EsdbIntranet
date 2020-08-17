package technicalResources.bsc;

public class BscCommonExcoBean {

	String perspective;
	String period;
	String reportingFrequency; 
	String measure;
	float base;
	float stretch;
	
	

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

	public String getPerspective() {
		return perspective;
	}

	public void setPerspective(String perspective) {
		this.perspective = perspective;
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

	public BscCommonExcoBean(String perspective, String period,
			String reportingFrequency, String measure, float base, float stretch) {
		super();
		this.perspective = perspective;
		this.period = period;
		this.reportingFrequency = reportingFrequency;
		this.measure = measure;
		this.base = base;
		this.stretch = stretch;
	}



}
