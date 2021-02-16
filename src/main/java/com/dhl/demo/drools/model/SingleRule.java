package com.dhl.demo.drools.model;

public class SingleRule {

	private String statusName;
	private int priorityLv;
	private String defaultText;

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public int getPriorityLv() {
		return priorityLv;
	}

	public void setPriorityLv(int priorityLv) {
		this.priorityLv = priorityLv;
	}

	public String getDefaultText() {
		return defaultText;
	}

	public void setDefaultText(String defaultText) {
		this.defaultText = defaultText;
	}

}
