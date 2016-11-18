package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.grading.ProjectAssessment;
import com.bitwise.manageme.rssson.domain.projects.StudentProject;

public interface ProjectAssessmentService {

	public List<ProjectAssessment> findAll();
	
	public List<ProjectAssessment> findByProjectsAndArchived(StudentProject studentProject, Boolean archived);
	
	public ProjectAssessment save(ProjectAssessment projectAssessment);
	
	public void delete(ProjectAssessment projectAssessment);

}
