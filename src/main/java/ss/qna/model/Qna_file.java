package ss.qna.model;

public class Qna_file {
	
	private int num;
	private String realname;
	private String realpath;
	private String realsize;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getRealsize() {
		return realsize;
	}
	public void setRealsize(String realsize) {
		this.realsize = realsize;
	}
	@Override
	public String toString() {
		return "Qna_file [num=" + num + ", realname=" + realname + ", realpath=" + realpath + ", realsize=" + realsize
				+ "]";
	}
	
	
}
