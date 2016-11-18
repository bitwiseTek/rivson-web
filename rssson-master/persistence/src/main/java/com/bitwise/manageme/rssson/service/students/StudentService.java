package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 12/09/16
 *
 */
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;

public interface StudentService {

	public List<Student> findAll();
	
	public Page<Student> findAll(Pageable pageable);
	
	public Page<Student> findAllByPage(String studentId, String nationality, String stateOfOrigin, String lga, DateTime studyStartDate, 
			DateTime studyEndDate, StudyProgramme studyProgramme, StudentStudyEndReason studyEndReason, Pageable pageable);
	
	public Student findById(Long id);
	
	public List<Student> findActiveStudents();
	
	public Long countByStudyEndReason(StudentStudyEndReason endReason);
	
	public List<Student> findByStudyProgrammes(StudyProgramme programme);
	
	public List<Student> findActiveStudentsByStudyProgramme(StudyProgramme programme);
	
	public List<Student> findByUserVariables(String key, String value);
	
	public Student findByStudentId(String studentId);
	
	public Page<Student> findByStudentId(String studentId, Pageable pageable);
	
	//public List<Student> findByEmails(String email, Integer firstResult, Integer maxResult);
	
	//public List<Student> findByEmailsAndArchived(String email, boolean archived, Integer firstResult, Integer maxResult);
	
	public Student save(Student student);
	
	public void delete(Student student);
	
	public Boolean add(Student student);
	
	public Boolean update(Student student);
	
	public Boolean remove(Student student);

}
