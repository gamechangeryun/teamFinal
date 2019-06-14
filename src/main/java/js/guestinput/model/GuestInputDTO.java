package js.guestinput.model;

import java.util.Date;

public class GuestInputDTO {
	
	private int num;
	private int rn;
	private int id;
	private String title;
	private String name;
	private int selectBoard;
	private String phone;
	private String email;
	private String reason;
	private Date writedate;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSelectBoard() {
		return selectBoard;
	}
	public void setSelectBoard(int selectBoard) {
		this.selectBoard = selectBoard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	
	@Override
	public String toString() {
		return "GuestInputDTO [num=" + num + ", rn=" + rn + ", id=" + id + ", title=" + title + ", name=" + name
				+ ", selectBoard=" + selectBoard + ", phone=" + phone + ", email=" + email + ", reason=" + reason
				+ ", writedate=" + writedate + "]";
	}

}
