package sr.tuition.model;

import java.util.Date;

public class TemperDTO {

	private int temper_num;
	private String temper_name;
	private Date temper_date;
	
	public int getTemper_num() {
		return temper_num;
	}

	public void setTemper_num(int temper_num) {
		this.temper_num = temper_num;
	}

	public String getTemper_name() {
		return temper_name;
	}

	public void setTemper_name(String temper_name) {
		this.temper_name = temper_name;
	}

	public Date getTemper_date() {
		return temper_date;
	}

	public void setTemper_date(Date temper_date) {
		this.temper_date = temper_date;
	}

	@Override
	public String toString() {
		return "TemperDTO [temper_num=" + temper_num + ", temper_name=" + temper_name + ", temper_date=" + temper_date
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
