package sz.co.swazibank.beans;

public class DirectoryBean {
	
	@Override
	public String toString() {
		return "DirectoryBean [ name=" + name + ", sirName="
				+ sirName + ", department=" + department + ", extension="
				+ extension + ", organisationalEmail=" + organisationalEmail
				+ "]";
	}
	String name;
	String sirName;
	String department;
	String extension;
	String organisationalEmail;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSirName() {
		return sirName;
	}
	public void setSirName(String sirName) {
		this.sirName = sirName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getOrganisationalEmail() {
		return organisationalEmail;
	}
	public void setOrganisationalEmail(String organisationalEmail) {
		this.organisationalEmail = organisationalEmail;
	}
	public DirectoryBean( String name, String sirName, String department,
			String extension, String organisationalEmail) {
		super();
		this.name = name;
		this.sirName = sirName;
		this.department = department;
		this.extension = extension;
		this.organisationalEmail = organisationalEmail;
	} 
	
	

}

