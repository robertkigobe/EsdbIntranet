package sz.co.swazibank.beans;

public class EmployeeBirthday {
	
	String empNo;
		      String firstName;
		      String lastName;
		      String position;
		      String department;
		      String date;
		      
			public String getEmpNo() {
				return empNo;
			}
			public void setEmpNo(String empNo) {
				this.empNo = empNo;
			}
			public String getFirstName() {
				return firstName;
			}
			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}
			public String getLastName() {
				return lastName;
			}
			public void setLastName(String lastName) {
				this.lastName = lastName;
			}
			public String getPosition() {
				return position;
			}
			public void setPosition(String position) {
				this.position = position;
			}
			public String getDepartment() {
				return department;
			}
			public void setDepartment(String department) {
				this.department = department;
			}
			public String getDate() {
				return date;
			}
			public void setDate(String date) {
				this.date = date;
			}
			public EmployeeBirthday(String empNo, String firstName,
					String lastName, String position, String department,
					String date) {
				super();
				this.empNo = empNo;
				this.firstName = firstName;
				this.lastName = lastName;
				this.position = position;
				this.department = department;
				this.date = date;
			}
			
		      
		      
			

}
