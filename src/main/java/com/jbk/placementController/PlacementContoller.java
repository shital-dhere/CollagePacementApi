package com.jbk.placementController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Student;
import com.jbk.exception.ProductAlreadyExistsException;
import com.jbk.model.StudentCompany;
import com.jbk.service.Service;

@RestController
public class PlacementContoller {
	@Autowired
	Service service;

	@PostMapping("register")
	public ResponseEntity<Boolean> registerForDrive(@Valid @RequestBody Student student) {

		boolean isAdded = service.registerForDrive(student);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			throw new ProductAlreadyExistsException("student already exists ID==" + student.getId());
		}

	}

	@GetMapping("getall_students")

	public ResponseEntity<List<Student>> getAllStudents() {

		List<Student> ls = service.getAllStudents();
		return new ResponseEntity<List<Student>>(ls, HttpStatus.OK);

	}

	@GetMapping("getbyid/{id}")
	public Student getStudentById(@PathVariable int id) {

		return service.getStudentById(id);

	}

	@PutMapping("update/{id}")
	public boolean updateStudent(@PathVariable int id, @RequestBody Student student) {
		return service.updateStudent(id, student);

	}

	@DeleteMapping("delete/{id}")
	public boolean deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);

	}

	@GetMapping("gettotal_count")
	public long getTotalStudent() {
		return service.getTotalStudent();

	}

	@GetMapping("eligible_candidates")
	public List<Student> eligibleForDrive() {
		return service.eligibleForDrive();

	}

	@GetMapping("sortbyname")
	public List<Student> sortByName() {
		return service.sortByName();

	}

	@GetMapping("comp_student")
	public List<Student> compStudent() {
		return service.compStudent();

	}

	@GetMapping("entc_student")
	public List<Student> entc_Students() {
		return service.entc_Students();

	}

	@GetMapping("mech_student")
	public List<Student> mech_Students() {
		return service.mech_Students();

	}

	@GetMapping("eligible_candidate_gothrough")
	public String programmStart() {
		return service.programmStartt();
	}

	@GetMapping("check_result/{id}")
	public ResponseEntity<StudentCompany> getStudent_withCompany(@PathVariable int id) {
		StudentCompany ps = service.getStudent_withCompany(id);

		return new ResponseEntity<StudentCompany>(ps, HttpStatus.OK);

	}

}
