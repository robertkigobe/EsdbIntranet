package technicalResources.corporateServices;

public class Inspection {

	String dateOfInspection;
	String branchDivision;
	String representative;
	
	public Inspection(String dateOfInspection, String branchDivision,
			String representative) {
		super();
		this.dateOfInspection = dateOfInspection;
		this.branchDivision = branchDivision;
		this.representative = representative;
	}

	public String getDateOfInspection() {
		return dateOfInspection;
	}

	public void setDateOfInspection(String dateOfInspection) {
		this.dateOfInspection = dateOfInspection;
	}

	public String getBranchDivision() {
		return branchDivision;
	}

	public void setBranchDivision(String branchDivision) {
		this.branchDivision = branchDivision;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	@Override
	public String toString() {
		return "Inspection [dateOfInspection=" + dateOfInspection
				+ ", branchDivision=" + branchDivision + ", representative="
				+ representative + "]";
	}
	
	
	
}
