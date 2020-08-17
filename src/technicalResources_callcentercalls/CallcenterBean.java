package technicalResources_callcentercalls;

public class CallcenterBean {
	
    String customerQuery;
    String dateClosed;
    String dateModified;
    String dateOpened;
    String departmentResponsible;
    String emailCopyTo;
    String emailReplyTo;
    String emailReplyCopyTo;
    String emailSentTo;
    String lastModifiedBy;
    String nameOfAgent;
    String nameOfCustomer;
    String nameOfStaff;
    String resolution;
    String status;
    
	public String getCustomerQuery() {
		return customerQuery;
	}
	public void setCustomerQuery(String customerQuery) {
		this.customerQuery = customerQuery;
	}
	public String getDateClosed() {
		return dateClosed;
	}
	public void setDateClosed(String dateClosed) {
		this.dateClosed = dateClosed;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	public String getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}
	public String getDepartmentResponsible() {
		return departmentResponsible;
	}
	public void setDepartmentResponsible(String departmentResponsible) {
		this.departmentResponsible = departmentResponsible;
	}
	public String getEmailCopyTo() {
		return emailCopyTo;
	}
	public void setEmailCopyTo(String emailCopyTo) {
		this.emailCopyTo = emailCopyTo;
	}
	public String getEmailReplyTo() {
		return emailReplyTo;
	}
	public void setEmailReplyTo(String emailReplyTo) {
		this.emailReplyTo = emailReplyTo;
	}
	public String getEmailReplyCopyTo() {
		return emailReplyCopyTo;
	}
	public void setEmailReplyCopyTo(String emailReplyCopyTo) {
		this.emailReplyCopyTo = emailReplyCopyTo;
	}
	public String getEmailSentTo() {
		return emailSentTo;
	}
	public void setEmailSentTo(String emailSentTo) {
		this.emailSentTo = emailSentTo;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public String getNameOfAgent() {
		return nameOfAgent;
	}
	public void setNameOfAgent(String nameOfAgent) {
		this.nameOfAgent = nameOfAgent;
	}
	public String getNameOfCustomer() {
		return nameOfCustomer;
	}
	public void setNameOfCustomer(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}
	public String getNameOfStaff() {
		return nameOfStaff;
	}
	public void setNameOfStaff(String nameOfStaff) {
		this.nameOfStaff = nameOfStaff;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CallcenterBean(String customerQuery, String dateClosed,
			String dateModified, String dateOpened,
			String departmentResponsible, String emailCopyTo,
			String emailReplyTo, String emailReplyCopyTo, String emailSentTo,
			String lastModifiedBy, String nameOfAgent, String nameOfCustomer,
			String nameOfStaff, String resolution, String status) {
		super();
		this.customerQuery = customerQuery;
		this.dateClosed = dateClosed;
		this.dateModified = dateModified;
		this.dateOpened = dateOpened;
		this.departmentResponsible = departmentResponsible;
		this.emailCopyTo = emailCopyTo;
		this.emailReplyTo = emailReplyTo;
		this.emailReplyCopyTo = emailReplyCopyTo;
		this.emailSentTo = emailSentTo;
		this.lastModifiedBy = lastModifiedBy;
		this.nameOfAgent = nameOfAgent;
		this.nameOfCustomer = nameOfCustomer;
		this.nameOfStaff = nameOfStaff;
		this.resolution = resolution;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "CallcenterBean [customerQuery=" + customerQuery
				+ ", dateClosed=" + dateClosed + ", dateModified="
				+ dateModified + ", dateOpened=" + dateOpened
				+ ", departmentResponsible=" + departmentResponsible
				+ ", emailCopyTo=" + emailCopyTo + ", emailReplyTo="
				+ emailReplyTo + ", emailReplyCopyTo=" + emailReplyCopyTo
				+ ", emailSentTo=" + emailSentTo + ", lastModifiedBy="
				+ lastModifiedBy + ", nameOfAgent=" + nameOfAgent
				+ ", nameOfCustomer=" + nameOfCustomer + ", nameOfStaff="
				+ nameOfStaff + ", resolution=" + resolution + ", status="
				+ status + "]";
	}
    

}
