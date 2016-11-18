package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 11/09/16
 *
 */
import java.util.List;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
//import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Join;
//import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;
import com.bitwise.manageme.rssson.domain.students.Student_;
import com.bitwise.manageme.rssson.domain.users.UserVariable;
import com.bitwise.manageme.rssson.domain.users.UserVariable_;

@Repository("studentRepository")
public class JpaStudentRepository implements StudentRepository {
	
	final Logger logger = LoggerFactory.getLogger(JpaStudentRepository.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void delete(Student student) {
		logger.info("Deleting student with ID " + student.getId());
		this.em.remove(em.merge(student));
	}

	@Override
	public void delete(Iterable<? extends Student> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Student> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findOne(Long id) {
		return this.em.createNamedQuery("Student.findById", Student.class).setParameter("id", id).getSingleResult();
	}

	@Override
	@Transactional
	public <S extends Student> S save(S student) {
		logger.info("Adding/Editing student with ID " + student.getId());
		return this.em.merge(student);
	}

	@Override
	public <S extends Student> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll() {
		return this.em.createNamedQuery("Student.findAll", Student.class).getResultList();
	}

	@Override
	public List<Student> findActiveStudents() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Student> query = cb.createQuery(Student.class);
		Root<Student> student = query.from(Student.class);
		query.select(student);
		query.where(cb.and(cb.equal(student.get(Student_.archived), Boolean.FALSE), 
				cb.or(cb.isNull(student.get(Student_.studyEndDate)), 
						cb.greaterThan(student.get(Student_.studyEndDate), new Date()))));
		return null;
	}

	@Override
	public Long countByStudyEndReason(StudentStudyEndReason endReason) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<Student> student = query.from(Student.class);
		query.select(cb.count(student));
		query.where(cb.equal(student.get(Student_.studyEndReason), endReason));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public List<Student> findByStudyProgrammes(StudyProgramme programme) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Student> query = cb.createQuery(Student.class);
		Root<Student> student = query.from(Student.class);
		query.select(student);
		query.where(cb.and(cb.equal(student.get(Student_.studyProgramme), programme), 
				cb.equal(student.get(Student_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<Student> findActiveStudentsByStudyProgramme(StudyProgramme programme) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Student> query = cb.createQuery(Student.class);
		Root<Student> student = query.from(Student.class);
		query.select(student);
		query.where(cb.and(cb.equal(student.get(Student_.studyProgramme), programme), 
				cb.equal(student.get(Student_.archived), Boolean.FALSE), 
				cb.or(cb.isNull(student.get(Student_.studyEndDate)), 
						cb.greaterThan(student.get(Student_.studyEndDate), new Date()))));
		return em.createQuery(query).getResultList();
	}

	@Override
	public List<Student> findByUserVariables(String key, String value) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Student> query = cb.createQuery(Student.class);
		Root<Student> student = query.from(Student.class);
		Root<UserVariable> variable = query.from(UserVariable.class);
		query.select(student);
		query.where(cb.and(cb.equal(student, variable.get(UserVariable_.user)), 
				cb.equal(student.get(Student_.archived), Boolean.FALSE), 
				cb.equal(variable.get(UserVariable_.key), key), 
				cb.equal(variable.get(UserVariable_.value), value)));
		return em.createQuery(query).getResultList();
	}

	@Override
	public Student findByStudentId(String studentId) {
		TypedQuery<Student> query = em.createNamedQuery("Student.findByStudentId", Student.class).setParameter("studentId", studentId);
		List<Student> students = query.getResultList();
		return students.size() == 1 ? students.get(0) : null;
	}

	@Override
	public Iterable<Student> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		TypedQuery<Student> query = em.createQuery("select s from Student s", Student.class);
		Page<Student> studentPage = new PageImpl<Student>(query.getResultList());
		return studentPage;
	}

	@Override
	public Page<Student> findByStudentId(String studentId, Pageable pageable) {
		TypedQuery<Student> query = em.createNamedQuery("Student.findByStudentId", Student.class).setParameter("studentId", studentId);
		Page<Student> studentPage = new PageImpl<Student>(query.getResultList());
		return studentPage;
	}

	@Override
	@Query("select s from Student s where s.studentId like :studentId and s.nationality like :nationality and s.stateOfOrigin like "
			+ ":stateOfOrigin and s.lga like :lga and s.studyStartDate like :studyStartDate and s.studyEndDate like :studyEndDate and s.studyEndReason.name like :studyEndReason "
			+ "and s.studyProgramme.name like :studyProgramme")
	public Page<Student> findAll(@Param("studentId") String studentId, 
			@Param("nationality") String nationality, 
			@Param("stateOfOrigin") String stateOfOrigin, 
			@Param("lga") String lga,
			@Param("studyStartDate") DateTime studyStartDate,
			@Param("studyEndDate") DateTime studyEndDate,
			@Param("studyEndReason") StudentStudyEndReason studyEndReason,
			@Param("studyProgramme") StudyProgramme studyProgramme, 
			Pageable pageable) {
		Page<Student> studentPage = new PageImpl<Student>(em.createNamedQuery("Student.findAllByPage", Student.class)
				.setParameter("studentId", studentId)
				.setParameter("nationality", nationality)
				.setParameter("stateOfOrigin", stateOfOrigin)
				.setParameter("lga", lga)
				.setParameter("studyStartDate", studyStartDate)
				.setParameter("studyEndDate", studyEndDate)
				.setParameter("studyEndReason", studyEndReason)
				.setParameter("studyProgramme", studyProgramme).getResultList());
		return studentPage;
	}

	/*@Override
	public List<Student> findByEmails(String email, Integer firstResult, Integer maxResult) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Student> query = cb.createQuery(Student.class);
		Root<Student> student = query.from(Student.class);
		Join<Student, ContactInfo> contactInfoJoin = student.join(Student_.contactInfo);
		ListJoin<ContactInfo, Email> emailJoin = (ListJoin) contactInfoJoin.join(ContactInfo_.emails);
		query.select(student);
		query.where(cb.equal(emailJoin.get(Email_.address), email));
		
		TypedQuery<Student> typedQuery = em.createQuery(query);
		if (firstResult != null) {
			typedQuery.setFirstResult(firstResult);
		}
		
		if (maxResult != null) {
			typedQuery.setMaxResults(maxResult);
		}
		return typedQuery.getResultList();
	}

	@Override
	public List<Student> findByEmailsAndArchived(String email, boolean archived, Integer firstResult, Integer maxResult) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Student> query = cb.createQuery(Student.class);
		Root<Student> student = query.from(Student.class);
		Join<Student, ContactInfo> contactInfoJoin = student.join(Student_.contactInfo);
		ListJoin<ContactInfo, Email> emailJoin = (ListJoin) contactInfoJoin.join(ContactInfo_.emails);
		query.select(student);
		query.where(cb.and(cb.equal(emailJoin.get(Email_.address), email), 
				cb.equal(student.get(Student_.archived), Boolean.FALSE)));
		
		TypedQuery<Student> typedQuery = em.createQuery(query);
		if (firstResult != null) {
			typedQuery.setFirstResult(firstResult);
		}
		
		if (maxResult != null) {
			typedQuery.setMaxResults(maxResult);
		}
		return typedQuery.getResultList();
	}*/

}
