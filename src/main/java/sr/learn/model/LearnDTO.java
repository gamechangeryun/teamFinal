package sr.learn.model;

public class LearnDTO {

	private int lecture_num;
	private String week;
	private String subject_title;
	private int max_study;
	private int now_study;
	
	public int getLecture_num() {
		return lecture_num;
	}
	public void setLecture_num(int lecture_num) {
		this.lecture_num = lecture_num;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getSubject_title() {
		return subject_title;
	}
	public void setSubject_title(String subject_title) {
		this.subject_title = subject_title;
	}
	public int getMax_study() {
		return max_study;
	}
	public void setMax_study(int max_study) {
		this.max_study = max_study;
	}
	public int getNow_study() {
		return now_study;
	}
	public void setNow_study(int now_study) {
		this.now_study = now_study;
	}
	@Override
	public String toString() {
		return "LearnDTO [lecture_num=" + lecture_num + ", week=" + week + ", subject_title=" + subject_title
				+ ", max_study=" + max_study + ", now_study=" + now_study + "]";
	}
	
	
	
}
