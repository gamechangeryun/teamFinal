package ss.qna.model;

import java.util.Date;

public class Qna_comment {
	
	private int comment_num;
	private int num;
	private String name;
	private Date Writedate;
	private String content;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getWritedate() {
		return Writedate;
	}
	public void setWritedate(Date writedate) {
		Writedate = writedate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Qna_comment [comment_num=" + comment_num + ", num=" + num + ", name=" + name + ", Writedate="
				+ Writedate + ", content=" + content + "]";
	}
	
	
}
