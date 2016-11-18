package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.grading.ProjectAssessment;
import com.bitwise.manageme.rssson.domain.projects.StudentProject;

public interface ProjectAssessmentRepository extends CrudRepository<ProjectAssessment, Long> {

	public List<ProjectAssessment> findAll();
	
	public List<ProjectAssessment> findByProjectsAndArchived(StudentProject studentProject, Boolean archived);
}
