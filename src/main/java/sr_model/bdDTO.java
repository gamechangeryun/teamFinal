package sr_model;

import java.util.Date;

public class bdDTO {

	private int rn;
	private int num;
	private int id;
	private String title;
	private String content;
	private Date writedate;
	private int readcount;
	private String isnotice;
	private String position;
	private int maxpeople;
	private int nowpeople;
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getIsnotice() {
		return isnotice;
	}
	public void setIsnotice(String isnotice) {
		this.isnotice = isnotice;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getMaxpeople() {
		return maxpeople;
	}
	public void setMaxpeople(int maxpeople) {
		this.maxpeople = maxpeople;
	}
	public int getNowpeople() {
		return nowpeople;
	}
	public void setNowpeople(int nowpeople) {
		this.nowpeople = nowpeople;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	@Override
	public String toString() {
		return "bdDTO [num=" + num + ", id=" + id + ", title=" + title + ", content=" + content + ", writedate="
				+ writedate + ", readcount=" + readcount + ", isnotice=" + isnotice + ", position=" + position
				+ ", maxpeople=" + maxpeople + ", nowpeople=" + nowpeople + "]";
	}
	

	
	
}
