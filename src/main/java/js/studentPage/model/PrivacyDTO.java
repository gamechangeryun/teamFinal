package js.studentPage.model;

public class PrivacyDTO {
	private String name;
	private String temper_name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTemper_name() {
		return temper_name;
	}
	public void setTemper_name(String temper_name) {
		this.temper_name = temper_name;
	}
	
	@Override
	public String toString() {
		return "PrivacyDTO [name=" + name + ", temper_name=" + temper_name + "]";
	}
	
}
