package js.scholarship.model;

public class ScholarshipDTO {
	private int id;
	private String name;
	private String temper_name;
	private String scholarship_name;
	private int scholarship_money;
	private int scholarship_num;
	private String scholarship_semester;
	private int rn;
	
	
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
	public String getTemper_name() {
		return temper_name;
	}
	public void setTemper_name(String temper_name) {
		this.temper_name = temper_name;
	}
	public String getScholarship_name() {
		return scholarship_name;
	}
	public void setScholarship_name(String scholarship_name) {
		this.scholarship_name = scholarship_name;
	}
	public int getScholarship_money() {
		return scholarship_money;
	}
	public void setScholarship_money(int scholarship_money) {
		this.scholarship_money = scholarship_money;
	}
	public int getScholarship_num() {
		return scholarship_num;
	}
	public void setScholarship_num(int scholarship_num) {
		this.scholarship_num = scholarship_num;
	}
	public String getScholarship_semester() {
		return scholarship_semester;
	}
	public void setScholarship_semester(String scholarship_semester) {
		this.scholarship_semester = scholarship_semester;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	
	@Override
	public String toString() {
		return "ScholarshipDTO [id=" + id + ", name=" + name + ", temper_name=" + temper_name + ", scholarship_name="
				+ scholarship_name + ", scholarship_money=" + scholarship_money + ", scholarship_num=" + scholarship_num
				+ ", scholarship_semester=" + scholarship_semester + ", rn=" + rn + "]";
	}
}
