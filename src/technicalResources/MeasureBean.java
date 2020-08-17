package technicalResources;

public class MeasureBean {
	
	String businesUnit;
	String position; 
	String perspective;
	String objective; 
	String measure;
	String description;
	public String getBusinesUnit() {
		return businesUnit;
	}
	public void setBusinesUnit(String businesUnit) {
		this.businesUnit = businesUnit;
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
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MeasureBean(String businesUnit, String position, String perspective,
			String objective, String measure, String description) {
		super();
		this.businesUnit = businesUnit;
		this.position = position;
		this.perspective = perspective;
		this.objective = objective;
		this.measure = measure;
		this.description = description;
	}
	
	
}