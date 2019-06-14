package js.reinapplysubmit.model;

import java.util.Date;

public class ReinApplySubmitDTO {
	private int rn;
	private int id;
	private String name;
	private String temper_name;
	private Date startreindate;
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
	public Date getStartreindate() {
		return startreindate;
	}
	public void setStartreindate(Date startreindate) {
		this.startreindate = startreindate;
	}
	public Date getReceivedate() {
		return receivedate;
	}
	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}
	
	@Override
	public String toString() {
		return "ReinApplySubmitDTO [rn=" + rn + ", id=" + id + ", name=" + name + ", temper_name=" + temper_name
				+ ", startreindate=" + startreindate + ", receivedate=" + receivedate + "]";
	}
	
}
