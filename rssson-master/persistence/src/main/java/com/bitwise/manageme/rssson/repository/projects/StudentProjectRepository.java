package com.bitwise.manageme.rssson.repository.projects;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.projects.Project;
import com.bitwise.manageme.rssson.domain.projects.StudentProject;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface StudentProjectRepository extends CrudRepository<StudentProject, Long> {

	public List<StudentProject> findAll();
	
	public List<StudentProject> findByStudents(Student student);
	
	public List<StudentProject> findByProjects(Project project);
		
}
