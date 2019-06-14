package KH.spring.jjin.DTO;

import java.util.Date;

public class WolDTO {
private int id;
private String name;
private int howmuch;
private int commition;
private Date month;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getHowmuch() {
	return howmuch;
}
public void setHowmuch(int howmuch) {
	this.howmuch = howmuch;
}
public int getCommition() {
	return commition;
}
public void setCommition(int commition) {
	this.commition = commition;
}
public WolDTO() {
	super();
}
public Date getMonth() {
	return month;
}
public void setMonth(Date month) {
	this.month = month;
}

@Override
public String toString() {
	return "WolDTO [id=" + id + ", name=" + name + ", howmuch=" + howmuch + ", commition=" + commition + ", month="
			+ month + "]";
}

}
