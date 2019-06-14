package KH.spring.jjin.DTO;
import java.util.*;

public class CclsDTO {
private int lecture_num;
private int id;
private String name;
private Date canceled_date;
private String canceled_reason;
private Date supply_date;
private String lecture_title;
private String y_or_n;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getLecture_num() {
	return lecture_num;
}
public void setLecture_num(int lecture_num) {
	this.lecture_num = lecture_num;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getCanceled_date() {
	return canceled_date;
}
public void setCanceled_date(Date canceled_date) {
	this.canceled_date = canceled_date;
}
public String getCanceled_reason() {
	return canceled_reason;
}
public void setCanceled_reason(String canceled_reason) {
	this.canceled_reason = canceled_reason;
}
public Date getSupply_date() {
	return supply_date;
}
public void setSupply_date(Date supply_date) {
	this.supply_date = supply_date;
}
public String getLecture_title() {
	return lecture_title;
}
public void setLecture_title(String lecture_title) {
	this.lecture_title = lecture_title;
}



public String getY_or_n() {
	return y_or_n;
}
public void setY_or_n(String y_or_n) {
	this.y_or_n = y_or_n;
}

@Override
public String toString() {
	return "CclsDTO [lecture_num=" + lecture_num + ", id=" + id + ", name=" + name + ", canceled_date=" + canceled_date
			+ ", canceled_reason=" + canceled_reason + ", supply_date=" + supply_date + ", lecture_title="
			+ lecture_title + ", y_or_n=" + y_or_n + "]";
}




}

