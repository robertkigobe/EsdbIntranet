package technicalResources.bsc;

public class BscObjectivesBean {
	
	String objective;
	String objectiveDesciption;
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getObjectiveDesciption() {
		return objectiveDesciption;
	}
	public void setObjectiveDesciption(String objectiveDesciption) {
		this.objectiveDesciption = objectiveDesciption;
	}
	public BscObjectivesBean(String objective, String objectiveDesciption) {
		super();
		this.objective = objective;
		this.objectiveDesciption = objectiveDesciption;
	}

}
