package technicalResources;

public class DepartmentBean {
	String code;
	String name;
	String em;
	public DepartmentBean(String code, String name, String em) {
		super();
		this.code = code;
		this.name = name;
		this.em = em;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEm() {
		return em;
	}
	public void setEm(String em) {
		this.em = em;
	}
	@Override
	public String toString() {
		return "Department [code=" + code + ", name=" + name + ", em=" + em
				+ "]";
	}
	
	
}
