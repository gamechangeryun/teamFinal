package wj.anonbd.model;

import java.util.Date;

public class AnonContentDto {
	int num;
	int id;
	String title;
	String writer;
	String content;
	Date writedate;
	int readcount;
	String isNotice;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getIsNotice() {
		return isNotice;
	}
	public void setIsNotice(String isNotice) {
		this.isNotice = isNotice;
	}
	
	@Override
	public String toString() {
		return "AnonCommentDto [num=" + num + ", id=" + id + ", title=" + title + ", writer=" + writer + ", content="
				+ content + ", writedate=" + writedate + ", readcount=" + readcount + ", isNotice=" + isNotice + "]";
	}
	
}
