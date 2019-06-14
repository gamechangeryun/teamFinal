package js.lectureapply.model;

import java.util.Date;

public class LectureApplyDTO {
	private int rn;
	private int lecture_num;
	private int id;
	private String name;
	private String temper_name;
	private String lecture_title;
	private int lecture_grade;
	private String roomcode;
	private int timecode;
	private Date writedate;
	private String semester;
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
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
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	public int getTimecode() {
		return timecode;
	}
	public void setTimecode(int timecode) {
		this.timecode = timecode;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	@Override
	public String toString() {
		return "LectureApplyDTO [rn=" + rn + ", lecture_num=" + lecture_num + ", id=" + id + ", name=" + name
				+ ", temper_name=" + temper_name + ", lecture_title=" + lecture_title + ", lecture_grade="
				+ lecture_grade + ", roomcode=" + roomcode + ", timecode=" + timecode + ", writedate=" + writedate
				+ ", semester=" + semester + "]";
	}

	

}
