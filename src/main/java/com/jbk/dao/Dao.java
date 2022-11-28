package com.jbk.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.jbk.entity.Student;

public interface Dao {
	public boolean	registerForDrive(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(int id);
	public boolean updateStudent(int id,Student student);
	public boolean deleteStudent(int id);
	public long getTotalStudent();
	public List<Student> eligibleForDrive();
	public List<Student> sortByName();
	public List<Student> compStudent();
	public List<Student> entc_Students();
	public List<Student> mech_Students();

}
