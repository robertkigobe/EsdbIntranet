package home;

public class ServeltCountBean {
	String userName;
	String servletName;
	String dateNow;
	int hitCount;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getServletName() {
		return servletName;
	}
	public void setServletName(String servletName) {
		this.servletName = servletName;
	}
	public String getDateNow() {
		return dateNow;
	}
	public void setDateNow(String dateNow) {
		this.dateNow = dateNow;
	}
	public int getCount() {
		return hitCount;
	}
	public void setCount(int count) {
		this.hitCount = count;
	}
	public ServeltCountBean(String userName, String servletName,
			String dateNow, int count) {
		super();
		this.userName = userName;
		this.servletName = servletName;
		this.dateNow = dateNow;
		this.hitCount = count;
	}

}
