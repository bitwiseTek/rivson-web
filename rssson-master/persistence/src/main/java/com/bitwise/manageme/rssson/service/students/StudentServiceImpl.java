package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 12/09/16
 *
 */
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;
import com.bitwise.manageme.rssson.repository.students.StudentRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Student> findAll() {
		return Lists.newArrayList(this.studentRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<Student> findActiveStudents() {
		return this.studentRepo.findActiveStudents();
	}

	@Override
	@Transactional(readOnly=true)
	public Long countByStudyEndReason(StudentStudyEndReason endReason) {
		return this.studentRepo.countByStudyEndReason(endReason);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Student> findByStudyProgrammes(StudyProgramme programme) {
		return this.studentRepo.findByStudyProgrammes(programme);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Student> findActiveStudentsByStudyProgramme(StudyProgramme programme) {
		return this.studentRepo.findActiveStudentsByStudyProgramme(programme);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Student> findByUserVariables(String key, String value) {
		return this.studentRepo.findByUserVariables(key, value);
	}

	/*@Override
	@Transactional(readOnly=true)
	public List<Student> findByEmails(String email, Integer firstResult, Integer maxResult) {
		return this.studentRepo.findByEmails(email, firstResult, maxResult);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Student> findByEmailsAndArchived(String email, boolean archived, Integer firstResult, Integer maxResult) {
		return this.studentRepo.findByEmailsAndArchived(email, archived, firstResult, maxResult);
	}*/

	@Override
	@Transactional(readOnly=false)
	public Student save(Student student) {
		return this.studentRepo.save(student);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Student student) {
		this.studentRepo.delete(student);
	}

	@Override
	@Transactional(readOnly=true)
	public Student findByStudentId(String studentId) {
		return this.studentRepo.findByStudentId(studentId);
	}

	@Override
	@Transactional(readOnly=true)
	public Student findById(Long id) {
		return this.studentRepo.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Student> findAll(Pageable pageable) {
		return this.studentRepo.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Student> findAllByPage(String studentId, String nationality, String stateOfOrigin, String lga,
			DateTime studyStartDate, DateTime studyEndDate, StudyProgramme studyProgramme,
			StudentStudyEndReason studyEndReason, Pageable pageable) {
		return this.studentRepo.findAll(studentId, nationality, stateOfOrigin, lga, studyStartDate, studyEndDate, studyEndReason, studyProgramme, pageable);
	}

	@Override
	public Page<Student> findByStudentId(String studentId, Pageable pageable) {
		return this.studentRepo.findByStudentId(studentId, pageable);
	}

	@Override
	@Transactional(readOnly=false)
	public Boolean add(Student student) {
		Student saved = this.studentRepo.save(student);
		if (saved == null) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly=false)
	public Boolean update(Student student) {
		Student existingStudent = this.studentRepo.findByStudentId(student.getStudentId());
		if (existingStudent == null) {
			return false;
		}
		existingStudent.setNationality(student.getNationality());
		existingStudent.setStateOfOrigin(student.getStateOfOrigin());
		existingStudent.setLga(student.getLga());
		Student saved = this.studentRepo.save(existingStudent);
		if (saved == null) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional(readOnly=false)
	public Boolean remove(Student student) {
		Student existingStudent = this.studentRepo.findByStudentId(student.getStudentId());
		if (existingStudent == null) {
			return false;
		}
		this.studentRepo.delete(existingStudent);
		Student deletedStudent = this.studentRepo.findByStudentId(student.getStudentId());
		if (deletedStudent != null) {
			return false;
		}
		return true;
	}

}
