package com.bitwise.manageme.rssson.repository.projects;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.projects.Project;

@Repository("projectRepository")
public class JpaProjectRepository implements ProjectRepository {

	final Logger logger = LoggerFactory.getLogger(Project.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Project arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Project> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Project> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project findOne(Long id) {
		return this.em.createNamedQuery("Project.findById", Project.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends Project> S save(S project) {
		logger.info("Adding project with ID " + project.getId());
		project.setCreated(new Date(System.currentTimeMillis()));
		return this.em.merge(project);
	}

	@Override
	public <S extends Project> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findAll() {
		return this.em.createNamedQuery("Project.findAll", Project.class).getResultList();
	}
	//TO DO
	//1. searchProjectsBasic()
	//2. searchProjects()
}
