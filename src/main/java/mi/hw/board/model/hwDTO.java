package mi.hw.board.model;

import java.util.Date;

public class hwDTO {

	private int rn;
	private int homework_num;
	private int lecture_num;
	private String homework_title;
	private Date homework_date;
	private int id;
	private String homework_sub;
	private int readcount;
	private String realname;
	private String realpath;
	private long realsize;
	private String name;
	private int num;
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getHomework_num() {
		return homework_num;
	}
	public void setHomework_num(int homework_num) {
		this.homework_num = homework_num;
	}
	public int getLecture_num() {
		return lecture_num;
	}
	public void setLecture_num(int lecture_num) {
		this.lecture_num = lecture_num;
	}
	public String getHomework_title() {
		return homework_title;
	}
	public void setHomework_title(String homework_title) {
		this.homework_title = homework_title;
	}
	public Date getHomework_date() {
		return homework_date;
	}
	public void setHomework_date(Date homework_date) {
		this.homework_date = homework_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHomework_sub() {
		return homework_sub;
	}
	public void setHomework_sub(String homework_sub) {
		this.homework_sub = homework_sub;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "hwDTO [rn=" + rn + ", homework_num=" + homework_num + ", lecture_num=" + lecture_num
				+ ", homework_title=" + homework_title + ", homework_date=" + homework_date + ", id=" + id
				+ ", homework_sub=" + homework_sub + ", readcount=" + readcount + ", realname=" + realname
				+ ", realpath=" + realpath + ", realsize=" + realsize + ", name=" + name + ", num=" + num + "]";
	}
	
}