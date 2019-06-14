package js.leaveapplysubmit.model;

import java.util.Date;

public class LeaveApplySubmitDTO {
	
	private int rn;
	private int id;
	private String name;
	private String temper_name;
	private Date startleavedate;
	private Date endleavedate;
	private String reason;
	private Date receivedate;
	
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
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
	public Date getStartleavedate() {
		return startleavedate;
	}
	public void setStartleavedate(Date startleavedate) {
		this.startleavedate = startleavedate;
	}
	public Date getEndleavedate() {
		return endleavedate;
	}
	public void setEndleavedate(Date endleavedate) {
		this.endleavedate = endleavedate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getReceivedate() {
		return receivedate;
	}
	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}
	
	@Override
	public String toString() {
		return "LeaveApplySubmitDTO [id=" + id + ", name=" + name + ", temper_name=" + temper_name + ", startleavedate="
				+ startleavedate + ", endleavedate=" + endleavedate + ", reason=" + reason + ", receivedate="
				+ receivedate + "]";
	}
	
}
