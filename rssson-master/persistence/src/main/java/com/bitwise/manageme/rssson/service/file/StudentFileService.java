package com.bitwise.manageme.rssson.service.file;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.file.StudentFile;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface StudentFileService {

	public List<StudentFile> findAll();
	
	public List<StudentFile> findByStudent(Student student);
	
	public StudentFile save(StudentFile studentFile);
	
}
