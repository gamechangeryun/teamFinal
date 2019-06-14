package sr_model;

public class MtFileDTO {

	private int num;
	private String realname;
	private String realpath;
	private long realsize;
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
	
	public long getRealsize() {
		return realsize;
	}
	public void setRealsize(long realsize) {
		this.realsize = realsize;
	}
	@Override
	public String toString() {
		return "MtFileDTO [num=" + num + ", realname=" + realname + ", realpath=" + realpath + ", realsize="
				+ realsize + "]";
	}
}
