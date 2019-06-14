package js.canceledlecture.model;

import java.util.Date;

public class CanceledLectureDTO {
		private int rn;
		private int lecture_num;
		private String lecture_title;
		private int id;
		private String name;
		private String temper_name;
		private Date canceled_date;
		private Date supply_date;
		private String canceled_reason;
		private Date applydate;
		
		public int getRn() {
			return rn;
		}
		public void setRn(int rn) {
			this.rn = rn;
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
		public String getTemper_name() {
			return temper_name;
		}
		public void setTemper_name(String temper_name) {
			this.temper_name = temper_name;
		}
		public Date getCanceled_date() {
			return canceled_date;
		}
		public void setCanceled_date(Date canceled_date) {
			this.canceled_date = canceled_date;
		}
		public Date getSupply_date() {
			return supply_date;
		}
		public void setSupply_date(Date supply_date) {
			this.supply_date = supply_date;
		}
		public String getCanceled_reason() {
			return canceled_reason;
		}
		public void setCanceled_reason(String canceled_reason) {
			this.canceled_reason = canceled_reason;
		}
		public Date getApplydate() {
			return applydate;
		}
		public void setApplydate(Date applydate) {
			this.applydate = applydate;
		}
		
		@Override
		public String toString() {
			return "CanceledLectureDTO [lecture_num=" + lecture_num + ", lecture_title=" + lecture_title + ", id=" + id
					+ ", name=" + name + ", temper_name=" + temper_name + ", canceled_date=" + canceled_date
					+ ", supply_date=" + supply_date + ", canceled_reason=" + canceled_reason + ", applydate="
					+ applydate + "]";
		}
		
}
