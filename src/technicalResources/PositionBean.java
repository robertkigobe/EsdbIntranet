package technicalResources;

public class PositionBean {
	
	String position;
	String name;
	String userName;
	String category;
	String item;
	String rating;
	String priority;
	String remarks;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public PositionBean(String position, String name, String userName,
			String category, String item, String rating, String priority,
			String remarks) {
		super();
		this.position = position;
		this.name = name;
		this.userName = userName;
		this.category = category;
		this.item = item;
		this.rating = rating;
		this.priority = priority;
		this.remarks = remarks;
	}
	
	
	
	
}
