package sr_model;

public class requestDTO {

	private int num;
	private int id;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "requestDTO [num=" + num + ", id=" + id + "]";
	}
}
