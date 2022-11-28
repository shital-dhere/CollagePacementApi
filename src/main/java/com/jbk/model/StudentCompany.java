package com.jbk.model;

import com.jbk.entity.Student;

public class StudentCompany {
	Student student;
	Company company;

	public StudentCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentCompany(Student student, Company company) {
		super();
		this.student = student;
		this.company = company;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "StudentCompany [student=" + student + ", company=" + company + "]";
	}

}
