package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Student;

@Repository
public class DaoImpl implements Dao {
	@Autowired
	SessionFactory sf;

	@Override
	public boolean registerForDrive(Student student) {
		Session session = sf.openSession();
		boolean isAdded = false;

		try {
			Student stu2 = session.get(Student.class, student.getId());

			if (stu2 == null) {
				Transaction transaction = session.beginTransaction();
				session.save(student);
				transaction.commit();
				isAdded = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		List<Student> list = criteria.list();
		return list;

	}

	@Override
	public Student getStudentById(int id) {

		Session session = sf.openSession();
		Student student = null;
		try {
			student = session.get(Student.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean updateStudent(int id, Student student) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isUpdated = false;
		Student stu = session.get(Student.class, student.getId());
		session.evict(stu);
		try {
			if (stu != null) {
				session.update(student);
				transaction.commit();
				isUpdated = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;

	}

	@Override
	public boolean deleteStudent(int id) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;
		Student stu = session.get(Student.class, id);
		try {
			if (stu != null) {
				session.delete(stu);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isDeleted;

	}

	@Override
	public long getTotalStudent() {
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		criteria.setProjection(Projections.rowCount());
		long count = (long) criteria.uniqueResult();
		return count;

	}

	@Override
	public List<Student> eligibleForDrive() {
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.gt("marks", 60f));
		List<Student> list = criteria.list();
		return list;
	}

	@Override
	public List<Student> sortByName() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);

		Criteria list = criteria.addOrder(Order.asc("name"));
		List<Student> list2 = criteria.list();
		return list2;

	}

	@Override
	public List<Student> compStudent() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);

		criteria.add(Restrictions.ilike("branch", "c", MatchMode.START));
		List<Student> list = criteria.list();

		return list;

	}

	@Override
	public List<Student> entc_Students() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.ilike("branch", "entc"));
		List<Student> list = criteria.list();
		return list;
	}

	@Override
	public List<Student> mech_Students() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.ilike("branch", "mech"));
		List<Student> list = criteria.list();
		return list;
		
	}

}
