package com.jbk.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jbk.dao.Dao;
import com.jbk.entity.Student;
import com.jbk.model.Company;
import com.jbk.model.StudentCompany;


@Component
public class ServiceImpl implements Service {
	@Autowired
	Dao dao;
	
	@Autowired
	RestTemplate rt;

	@Override
	public boolean registerForDrive(Student student) {
		boolean isAdded=dao.registerForDrive(student);
		return isAdded;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return dao.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) {
		
		return dao.getStudentById(id);
	}

	@Override
	public boolean updateStudent(int id, Student student) {
		
		return dao.updateStudent(id, student);
	}

	@Override
	public boolean deleteStudent(int id) {
		
		return dao.deleteStudent(id);
	}

	@Override
	public long getTotalStudent() {
		
		return dao.getTotalStudent();
	}

	@Override
	public List<Student> eligibleForDrive() {
		
		return dao.eligibleForDrive();
	}

	@Override
	public List<Student> sortByName() {
		
		return dao.sortByName();
	}

	@Override
	public List<Student> compStudent() {
	
		return dao.compStudent();
	}

	@Override
	public List<Student> entc_Students() {
	
		return dao.entc_Students();
	}

	@Override
	public List<Student> mech_Students() {
		
		return dao.mech_Students();
	}

	@Override
	public String programmStartt() {
	return	"go through following steps 1.Apptitude 2.technical 3.PI";
		
	}

	@Override
	public StudentCompany getStudent_withCompany(int id) {
		Student student= getStudentById(id);
		
		Company company=rt.getForObject("http://localhost:8090/get_comp_byid/"+ student.getCampanyId(), Company.class);
		
		StudentCompany sc=new StudentCompany(student, company);
		return sc;
	}

}
