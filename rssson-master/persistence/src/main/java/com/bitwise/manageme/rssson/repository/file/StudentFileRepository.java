package com.bitwise.manageme.rssson.repository.file;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.file.StudentFile;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface StudentFileRepository extends CrudRepository<StudentFile, Long> {

	public List<StudentFile> findAll();
	
	public List<StudentFile> findByStudent(Student student);
	
}
