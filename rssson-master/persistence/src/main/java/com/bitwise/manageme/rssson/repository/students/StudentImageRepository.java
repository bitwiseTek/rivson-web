package com.bitwise.manageme.rssson.repository.students;
/**
 *  
 * @author Sika Kay
 * @date 11/09/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentImage;

public interface StudentImageRepository extends CrudRepository<StudentImage, Long> {

	public List<StudentImage> findAll();
	
	public StudentImage findByStudent(Student student);
	
	public Boolean findStudentHasImage(Student student);
}
