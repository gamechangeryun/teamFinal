package mi.job.board.model;

import java.util.Date;

public class DTO {

	private int num;
	private int rn;
	private int id;
	private String name;
	private String title;
	private String content;
	private Date writedate;
	private int readcount;
	private String isnotice;
	private String realname;
	private String realpath;
	private long realsize;
	private String fakename;
	
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
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getRealpath() {
		return realpath;
	}
	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}
	public long getRealsize() {
		return realsize;
	}
	public void setRealsize(long realsize) {
		this.realsize = realsize;
	}
	public String getFakename() {
		return fakename;
	}
	public void setFakename(String fakename) {
		this.fakename = fakename;
	}
	@Override
	public String toString() {
		return "DTO [num=" + num + ", rn=" + rn + ", id=" + id + ", name=" + name + ", title=" + title + ", content="
				+ content + ", writedate=" + writedate + ", readcount=" + readcount + ", isnotice=" + isnotice
				+ ", realname=" + realname + ", realpath=" + realpath + ", realsize=" + realsize + ", fakename="
				+ fakename + "]";
	}
	
}