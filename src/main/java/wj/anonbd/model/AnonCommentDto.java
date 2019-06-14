package wj.anonbd.model;

import java.util.Date;

public class AnonCommentDto {
	
	int comment_num;
	int num;
	int id;
	String comment_writer;
	Date writedate;
	String content;
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
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
	public String getComment_writer() {
		return comment_writer;
	}
	public void setComment_writer(String comment_writer) {
		this.comment_writer = comment_writer;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "AnonCommentDto [comment_num=" + comment_num + ", num=" + num + ", id=" + id + ", comment_writer="
				+ comment_writer + ", writedate=" + writedate + ", content=" + content + "]";
	}
	
	
}
