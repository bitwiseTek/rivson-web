package com.bitwise.manageme.rssson.service.projects;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.projects.Project;

public interface ProjectService {

	public List<Project> findAll();

	public Project save(Project project);
}
