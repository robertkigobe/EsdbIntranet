package technicalResources;

public class ObjectiveBean {
	
	String id;
	String objective;
	String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	
	public ObjectiveBean(String id, String objective, String description) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.objective = objective;
		this.description = description;
	}
	
	
	
}