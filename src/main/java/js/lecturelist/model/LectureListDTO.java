package js.lecturelist.model;

public class LectureListDTO {
	private int lecture_num;
	private int id;
	private String lecture_title;
	private int lecture_grade;
	private String semester;
	private int timecode;
	private String roomcode;
	
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
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getTimecode() {
		return timecode;
	}
	public void setTimecode(int timecode) {
		this.timecode = timecode;
	}
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	
	@Override
	public String toString() {
		return "LectureListDTO [lecture_num=" + lecture_num + ", id=" + id + ", lecture_title=" + lecture_title
				+ ", lecture_grade=" + lecture_grade + ", semester=" + semester + ", timecode=" + timecode
				+ ", roomcode=" + roomcode + "]";
	}
	
}
