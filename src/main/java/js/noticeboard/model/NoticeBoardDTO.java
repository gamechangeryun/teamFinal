package js.noticeboard.model;

import java.util.Date;

public class NoticeBoardDTO {
	private int num;	// 실제 글번호
	private int rn;		// 가상 글번호
	private int id;
	private String name;
	private String title;
	private String content;
	private Date writedate;
	private int readcount;
	private String isnotice;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRn() {
		return rn;
	}
	public void setRm(int rn) {
		this.rn = rn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
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
	
	@Override
	public String toString() {
		return "NoticeBoardDTO [num=" + num + ", id=" + id + ", name=" + name + ", title=" + title + ", content="
				+ content + ", writedate=" + writedate + ", readcount=" + readcount + ", isnotice=" + isnotice + "]";
	}
	
}
