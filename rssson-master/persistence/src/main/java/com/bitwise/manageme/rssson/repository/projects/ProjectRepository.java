package com.bitwise.manageme.rssson.repository.projects;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.projects.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

	public List<Project> findAll();

}
