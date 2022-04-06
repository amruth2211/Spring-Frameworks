package com.springboot.my.org.crudapi.models;


import java.util.Date;

public class Title {
	private int workerRefId;
	private String workerTitle;
	private Date affectedFrom;
	
	public Title(int workerRefId, String workerTitle, Date affectedFrom) {
		this.workerRefId = workerRefId;
		this.workerTitle = workerTitle;
		this.affectedFrom = affectedFrom;
	}
	
	public Title(int workerRefId, String workerTitle) {
		this.workerRefId = workerRefId;
		this.workerTitle = workerTitle;
		this.affectedFrom = new Date();
	}
	
	public Title(String workerTitle) {
		this.workerTitle = workerTitle;
		this.affectedFrom = new Date();
	}
	
	public int getWorkerRefId() {
		return workerRefId;
	}
	public void setWorkerRefId(int workerRefId) {
		this.workerRefId = workerRefId;
	}
	public String getWorkerTitle() {
		return workerTitle;
	}
	public void setWorkerTitle(String workerTitle) {
		this.workerTitle = workerTitle;
	}
	public Date getAffectedFrom() {
		return affectedFrom;
	}
	public void setAffectedFrom(Date affectedFrom) {
		this.affectedFrom = affectedFrom;
	}

	@Override
	public String toString() {
		return "Title [workerRefId=" + workerRefId + ", workerTitle=" + workerTitle + ", affectedFrom=" + affectedFrom
				+ "]";
	}
	
}