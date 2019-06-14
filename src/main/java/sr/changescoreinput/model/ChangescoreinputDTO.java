package sr.changescoreinput.model;

public class ChangescoreinputDTO {

	private int lecture_num;
	private int id;
	private String name;
	private String changereason;
	
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
	public String getChangereason() {
		return changereason;
	}
	public void setChangereason(String changereason) {
		this.changereason = changereason;
	}
	@Override
	public String toString() {
		return "ChangescoreinputDTO [lecture_num=" + lecture_num + ", id=" + id + ", name=" + name + ", changereason="
				+ changereason + "]";
	}
	
}
