package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

	@Id
	@Min(1)
	private int id;

	@NotNull(message = "student name is required")
	private String name;

	@NotNull(message = "student branch is required")
	private String branch;

	@Min(1)
	private float marks;

	@NotNull(message = "student mail is required")
	private String mail;

	@NotNull(message = "student phone is required")
	private String phone;

	private int campanyId;

	public Student() {
		super();

	}

	public Student(@Min(1) int id, @NotNull(message = "student name is required") String name,
			@NotNull(message = "student branch is required") String branch, @Min(1) float marks,
			@NotNull(message = "student mail is required") String mail,
			@NotNull(message = "student phone is required") String phone, int campanyId) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.marks = marks;
		this.mail = mail;
		this.phone = phone;
		this.campanyId = campanyId;
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCampanyId() {
		return campanyId;
	}

	public void setCampanyId(int campanyId) {
		this.campanyId = campanyId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", branch=" + branch + ", marks=" + marks + ", mail=" + mail
				+ ", phone=" + phone + ", campanyId=" + campanyId + "]";
	}

}
