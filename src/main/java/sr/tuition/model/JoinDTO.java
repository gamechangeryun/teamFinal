package sr.tuition.model;

public class JoinDTO {
	private String temper_name;
	private String inputmoney;
	
	public String getTemper_name() {
		return temper_name;
	}
	public void setTemper_name(String temper_name) {
		this.temper_name = temper_name;
	}
	public String getInputmoney() {
		return inputmoney;
	}
	public void setInputmoney(String inputmoney) {
		this.inputmoney = inputmoney;
	}
	
	@Override
	public String toString() {
		return "JoinDTO [temper_name=" + temper_name + ", inputmoney=" + inputmoney + "]";
	}
	
	
}
