package KH.spring.jjin.DTO;

import java.util.Date;

public class MemberGDTO {
private int temper_num;		//gesinum
private String id;			//userid
private String passwd;
private String name;		//content
private String gender;
private String birthday;
private String grade;
private String phone;
private String email;
private String postcode;
private String address1;
private String address2;
private Date sub_date;




public int getTemper_num() {
	return temper_num;
}




public void setTemper_num(int temper_num) {
	this.temper_num = temper_num;
}




public String getId() {
	return id;
}




public void setId(String id) {
	this.id = id;
}




public String getPasswd() {
	return passwd;
}




public void setPasswd(String passwd) {
	this.passwd = passwd;
}




public String getName() {
	return name;
}




public void setName(String name) {
	this.name = name;
}




public String getGender() {
	return gender;
}




public void setGender(String gender) {
	this.gender = gender;
}




public String getBirthday() {
	return birthday;
}




public void setBirthday(String birthday) {
	this.birthday = birthday;
}




public String getGrade() {
	return grade;
}




public void setGrade(String grade) {
	this.grade = grade;
}




public String getPhone() {
	return phone;
}




public void setPhone(String phone) {
	this.phone = phone;
}




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public String getPostcode() {
	return postcode;
}




public void setPostcode(String postcode) {
	this.postcode = postcode;
}




public String getAddress1() {
	return address1;
}




public void setAddress1(String address1) {
	this.address1 = address1;
}




public String getAddress2() {
	return address2;
}




public void setAddress2(String address2) {
	this.address2 = address2;
}




public Date getSub_date() {
	return sub_date;
}




public void setSub_date(Date sub_date) {
	this.sub_date = sub_date;
}




public MemberGDTO() {
	super();
}



}
