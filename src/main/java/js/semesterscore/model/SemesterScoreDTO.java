package js.semesterscore.model;

public class SemesterScoreDTO {
	private int lecture_num;
	private String lecture_title;
	private int lecture_grade;
	private int id;
	private String name;
	private int score;
	private String semester;
	private int semesterpoint;
	private int semesteraverage;
	
	public int getLecture_num() {
		return lecture_num;
	}
	public void setLecture_num(int lecture_num) {
		this.lecture_num = lecture_num;
	}
	public String getLecture_title() {
		return lecture_title;
	}
	public void setLecture_title(String lecture_title) {
		this.lecture_title = lecture_title;
	}
	public int getLecture_grade() {
		return lecture_grade;
	}
	public void setLecture_grade(int lecture_grade) {
		this.lecture_grade = lecture_grade;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getSemesterpoint() {
		return semesterpoint;
	}
	public void setSemesterpoint(int semesterpoint) {
		this.semesterpoint = semesterpoint;
	}
	public int getSemesteraverage() {
		return semesteraverage;
	}
	public void setSemesteraverage(int semesteraverage) {
		this.semesteraverage = semesteraverage;
	}
	
	@Override
	public String toString() {
		return "SemesterScoreDTO [lecture_num=" + lecture_num + ", lecture_title=" + lecture_title + ", lecture_grade="
				+ lecture_grade + ", id=" + id + ", name=" + name + ", score=" + score + ", semester=" + semester
				+ ", semesterpoint=" + semesterpoint + ", semesteraverage=" + semesteraverage + "]";
	}
}
