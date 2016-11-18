package com.bitwise.manageme.rssson.service.projects;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.projects.Project;
import com.bitwise.manageme.rssson.domain.projects.StudentProject;
import com.bitwise.manageme.rssson.domain.students.Student;

public interface StudentProjectService {

	public List<StudentProject> findAll();
	
	public List<StudentProject> findByStudents(Student student);
	
	public List<StudentProject> findByProjects(Project project);
	
	public StudentProject save(StudentProject studentProject);
		
}
