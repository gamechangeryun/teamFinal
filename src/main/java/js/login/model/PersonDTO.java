package js.login.model;

public class PersonDTO {
	private int id;
	private int temper_num;
	private String password;
	private String name;
	private String gender;
	private String birthday;
	private String grade;
	private String phone;
	private String email;
	private int postcode;
	private String address1;
	private String address2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTemper_num() {
		return temper_num;
	}
	public void setTemper_num(int temper_num) {
		this.temper_num = temper_num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
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
	
	@Override
	public String toString() {
		return "PersonDTO [id=" + id + ", temper_num=" + temper_num + ", password=" + password + ", name=" + name
				+ ", gender=" + gender + ", birthday=" + birthday + ", grade=" + grade + ", phone=" + phone + ", email="
				+ email + ", postcode=" + postcode + ", address1=" + address1 + ", address2=" + address2 + "]";
	}
	
	
	
}
