package com.jbk.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.jbk.entity.Student;
import com.jbk.model.StudentCompany;

public interface Service {

	public boolean registerForDrive(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(int id);

	public boolean updateStudent(int id, Student student);

	public boolean deleteStudent(int id);

	public long getTotalStudent();

	public List<Student> eligibleForDrive();

	public List<Student> sortByName();

	public List<Student> compStudent();

	public List<Student> entc_Students();

	public List<Student> mech_Students();

	public String programmStartt();

	public StudentCompany getStudent_withCompany(int id);

}
