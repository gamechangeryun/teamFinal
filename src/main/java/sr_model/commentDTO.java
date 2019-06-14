package sr_model;

import java.util.Date;

public class commentDTO {

	private int comment_num;
	private int num;
	private int id;
	private String name;
	private Date writedate;
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
		return "commentDTO [comment_num=" + comment_num + ", num=" + num + ", id=" + id + ", name=" + name
				+ ", writedate=" + writedate + ", content=" + content + "]";
	}
	
	
}
