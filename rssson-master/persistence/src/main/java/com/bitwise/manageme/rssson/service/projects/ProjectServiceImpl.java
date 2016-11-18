package com.bitwise.manageme.rssson.service.projects;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.projects.Project;
import com.bitwise.manageme.rssson.repository.projects.ProjectRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Project> findAll() {
		return Lists.newArrayList(this.projectRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public Project save(Project project) {
		return this.projectRepo.save(project);
	}

}
