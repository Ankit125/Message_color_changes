package com.privatis.model;

public class Email {

	private String email;
	private String name;
	private String notes;
	private String time;
	private String flag;

	private String CreatedDate;
	private String EmailBody;
	private String EmailFrom;
	private String EmailSubject;
	private String EmailTo;
	private String IsRead;
	private String MemberId;
	private String MessageEmailId;
	private String RecordCount;

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
