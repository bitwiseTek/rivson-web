package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 11/09/16
 *
 */
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentStudyEndReason;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

	public List<Student> findAll();
	
	public List<Student> findActiveStudents();
	
	public Long countByStudyEndReason(StudentStudyEndReason endReason);
	
	public List<Student> findByStudyProgrammes(StudyProgramme programme);
	
	public List<Student> findActiveStudentsByStudyProgramme(StudyProgramme programme);
	
	public List<Student> findByUserVariables(String key, String value);
	
	public Student findByStudentId(String studentId);
	
	public Page<Student> findByStudentId(String studentId, Pageable pageable);
	
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
			@Param("studyProgramme") StudyProgramme studyProgramme, Pageable pageable);
	
	//public List<Student> findByEmails(String email, Integer firstResult, Integer maxResult);
	
	//public List<Student> findByEmailsAndArchived(String email, boolean archived, Integer firstResult, Integer maxResult);
	
	
}
