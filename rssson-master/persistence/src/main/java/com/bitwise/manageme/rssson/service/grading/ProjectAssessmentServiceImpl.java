package com.bitwise.manageme.rssson.service.grading;
/**
 *  
 * @author Sika Kay
 * @date 28/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.grading.ProjectAssessment;
import com.bitwise.manageme.rssson.domain.projects.StudentProject;
import com.bitwise.manageme.rssson.repository.grading.ProjectAssessmentRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("projectAssessmentService")
public class ProjectAssessmentServiceImpl implements ProjectAssessmentService {

	@Autowired
	private ProjectAssessmentRepository projectAssessmentRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<ProjectAssessment> findAll() {
		return Lists.newArrayList(this.projectAssessmentRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProjectAssessment> findByProjectsAndArchived(StudentProject studentProject, Boolean archived) {
		return this.projectAssessmentRepo.findByProjectsAndArchived(studentProject, archived);
	}

	@Override
	@Transactional(readOnly=false)
	public ProjectAssessment save(ProjectAssessment projectAssessment) {
		return this.projectAssessmentRepo.save(projectAssessment);
	}

	@Override
	public void delete(ProjectAssessment projectAssessment) {
		this.projectAssessmentRepo.delete(projectAssessment);
	}

}
