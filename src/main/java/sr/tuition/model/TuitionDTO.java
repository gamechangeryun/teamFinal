package sr.tuition.model;

import java.util.Date;

public class TuitionDTO {

	private int id;
	private int howmuch;
	private String inputmoney;
	private Date inputdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHowmuch() {
		return howmuch;
	}
	public void setHowmuch(int howmuch) {
		this.howmuch = howmuch;
	}
	public String getInputmoney() {
		return inputmoney;
	}
	public void setInputmoney(String inputmoney) {
		this.inputmoney = inputmoney;
	}
	public Date getInputdate() {
		return inputdate;
	}
	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}
	@Override
	public String toString() {
		return "TuitionDTO [id=" + id + ", howmuch=" + howmuch + ", inputmoney=" + inputmoney + ", inputdate="
				+ inputdate + "]";
	}
	
}
