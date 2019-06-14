package sr.scoreinput.model;

import java.util.List;

public class ScoreinputDTO {
	private int lecture_num;
	private String lecture_title;
	private int id;
	private String name;
	private String temper_name;
	//private int studentnum;
	//private String student_name;
	private int score;
	List<ScoreinputDTO> list;
	
	public ScoreinputDTO() {
	}

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

	public List<ScoreinputDTO> getList() {
		return list;
	}

	public void setList(List<ScoreinputDTO> list) {
		this.list = list;
	}

	public String getTemper_name() {
		return temper_name;
	}

	public void setTemper_name(String temper_name) {
		this.temper_name = temper_name;
	}

	@Override
	public String toString() {
		return "ScoreinputDTO [lecture_num=" + lecture_num + ", lecture_title=" + lecture_title + ", id=" + id
				+ ", name=" + name + ", temper_name=" + temper_name + ", score=" + score + ", list=" + list + "]";
	}
	
}
