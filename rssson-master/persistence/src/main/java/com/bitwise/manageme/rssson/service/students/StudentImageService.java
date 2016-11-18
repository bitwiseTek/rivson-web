package com.bitwise.manageme.rssson.service.students;
/**
 *  
 * @author Sika Kay
 * @date 12/09/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentImage;

public interface StudentImageService {

	public List<StudentImage> findAll();
	
	public StudentImage findById(Long id);
	
	public StudentImage findByStudent(Student student);
	
	public Boolean findStudentHasImage(Student student);
	
	public StudentImage save(StudentImage image);
	
	public void delete(StudentImage image);

}
