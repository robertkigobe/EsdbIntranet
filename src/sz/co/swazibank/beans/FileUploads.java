package sz.co.swazibank.beans;

import java.io.InputStream;
import java.sql.Date;

public class FileUploads {
	
	
	int id; 
	Date dated;
	String name;
	String department;
	String section;
	InputStream fileUpload;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public InputStream getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(InputStream fileUpload) {
		this.fileUpload = fileUpload;
	}
	public FileUploads(int id, Date dated, String name, String department,
			String section, InputStream fileUpload) {
		super();
		this.id = id;
		this.dated = dated;
		this.name = name;
		this.department = department;
		this.section = section;
		this.fileUpload = fileUpload;
	}
	
	
	
}