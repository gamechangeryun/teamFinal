package sr.pro.model;

public class ProDTO {
	private String name;
	private String temper_name;
	private String email;
	private String roomcode;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	
	@Override
	public String toString() {
		return "ProDTO [name=" + name + ", temper_name=" + temper_name + ", email=" + email + ", roomcode=" + roomcode
				+ "]";
	}
	
}
