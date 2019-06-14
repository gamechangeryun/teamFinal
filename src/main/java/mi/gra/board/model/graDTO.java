package mi.gra.board.model;

import java.util.Date;

public class graDTO {
	
	private int id;
	private String name;
	private int rn;
	private int temper_num;
	private String temper_name;
	private Date temper_date;
	private int num;
	private int lecture_num;
	private String totalaverage;
	private int maxpoint;
	private int nowpoint;
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
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public int getTemper_num() {
		return temper_num;
	}
	public void setTemper_num(int temper_num) {
		this.temper_num = temper_num;
	}
	public String getTemper_name() {
		return temper_name;
	}
	public void setTemper_name(String temper_name) {
		this.temper_name = temper_name;
	}
	public Date getTemper_date() {
		return temper_date;
	}
	public void setTemper_date(Date temper_date) {
		this.temper_date = temper_date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getLecture_num() {
		return lecture_num;
	}
	public void setLecture_num(int lecture_num) {
		this.lecture_num = lecture_num;
	}
	public String getTotalaverage() {
		return totalaverage;
	}
	public void setTotalaverage(String totalaverage) {
		this.totalaverage = totalaverage;
	}
	public int getMaxpoint() {
		return maxpoint;
	}
	public void setMaxpoint(int maxpoint) {
		this.maxpoint = maxpoint;
	}
	public int getNowpoint() {
		return nowpoint;
	}
	public void setNowpoint(int nowpoint) {
		this.nowpoint = nowpoint;
	}
	
	
	
}