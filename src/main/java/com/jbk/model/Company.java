package com.jbk.model;

public class Company {
	private int campanyId;
	private String campanyName;
	private String compPackage;

	public Company() {
		super();
		
	}

	public Company(int campanyId, String campanyName, String compPackage) {
		super();
		this.campanyId = campanyId;
		this.campanyName = campanyName;
		this.compPackage = compPackage;
	}

	public int getCampanyId() {
		return campanyId;
	}

	public void setCampanyId(int campanyId) {
		this.campanyId = campanyId;
	}

	public String getCampanyName() {
		return campanyName;
	}

	public void setCampanyName(String campanyName) {
		this.campanyName = campanyName;
	}

	public String getCompPackage() {
		return compPackage;
	}

	public void setCompPackage(String compPackage) {
		this.compPackage = compPackage;
	}

	@Override
	public String toString() {
		return "Company [campanyId=" + campanyId + ", campanyName=" + campanyName + ", compPackage=" + compPackage
				+ "]";
	}

}
