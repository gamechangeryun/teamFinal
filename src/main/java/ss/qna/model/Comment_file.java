package ss.qna.model;

public class Comment_file {
	
	private int comment_num;
	private String realname;
	private String realpath;
	private String realsize;
	
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
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
		return "Comment_file [comment_num=" + comment_num + ", realname=" + realname + ", realpath=" + realpath
				+ ", realsize=" + realsize + "]";
	}
	
	
}
