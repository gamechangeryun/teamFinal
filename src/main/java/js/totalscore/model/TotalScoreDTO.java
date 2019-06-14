package js.totalscore.model;

public class TotalScoreDTO {
	private int id;
	private String name;
	private String temper_name;
	private int totalaverage;
	private int maxpoint;
	private int nowpoint;
	
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
	public int getTotalaverage() {
		return totalaverage;
	}
	public void setTotalaverage(int totalaverage) {
		this.totalaverage = totalaverage;
	}
	public int getMaxpoint() {
		return maxpoint;
	}
	public void setMaxpoint(int maxpoint) {
		this.maxpoint = maxpoint;
	}
	public int getNowpoint() {
		return nowpoint;
	}
	public void setNowpoint(int nowpoint) {
		this.nowpoint = nowpoint;
	}
	
	@Override
	public String toString() {
		return "TotalScoreDTO [id=" + id + ", name=" + name + ", temper_name=" + temper_name + ", totalaverage="
				+ totalaverage + ", maxpoint=" + maxpoint + ", nowpoint=" + nowpoint + "]";
	}
	
	
	
}
