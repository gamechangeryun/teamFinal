package wj.person.model;

public class PictureDto {
	private int id;
	private String realname;
	private String realpath;
	private long realsize;
	
	@Override
	public String toString() {
		return "PictureDto [id=" + id + ", realname=" + realname + ", realpath=" + realpath + ", realsize=" + realsize
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getRealpath() {
		return realpath;
	}
	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}
	public long getRealsize() {
		return realsize;
	}
	public void setRealsize(long realsize) {
		this.realsize = realsize;
	}
	
}
