package technicalResources.bsc;

public class BscMeasureBean {
	
	String position;
	String measure;
	String measureDesciption;
	String perspective;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	public String getMeasureDesciption() {
		return measureDesciption;
	}
	public void setMeasureDesciption(String measureDesciption) {
		this.measureDesciption = measureDesciption;
	}
	public String getPerspective() {
		return perspective;
	}
	public void setPerspective(String perspective) {
		this.perspective = perspective;
	}
	public BscMeasureBean(String position, String measure,
			String measureDesciption, String perspective) {
		super();
		this.position = position;
		this.measure = measure;
		this.measureDesciption = measureDesciption;
		this.perspective = perspective;
	}

}
