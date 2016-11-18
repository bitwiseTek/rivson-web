package com.bitwise.manageme.rssson.repository.grading;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.grading.ProjectAssessment;
import com.bitwise.manageme.rssson.domain.grading.ProjectAssessment_;
import com.bitwise.manageme.rssson.domain.projects.StudentProject;

@Repository("projectAssessmentRepository")
public class JpaProjectAssessmentRepository implements ProjectAssessmentRepository {

	final Logger logger = LoggerFactory.getLogger(JpaProjectAssessmentRepository.class);
	
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
	public void delete(ProjectAssessment pa) {
		logger.info("Deleting project assessment with ID " + pa.getId());
		this.em.remove(pa);
	}

	@Override
	public void delete(Iterable<? extends ProjectAssessment> arg0) {
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
	public Iterable<ProjectAssessment> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectAssessment findOne(Long id) {
		return this.em.createNamedQuery("ProjectAssessment.findById", ProjectAssessment.class).getSingleResult();
	}

	@Override
	public <S extends ProjectAssessment> S save(S pa) {
		logger.info("Adding project assessment with ID " + pa.getId());
		return this.em.merge(pa);
	}

	@Override
	public <S extends ProjectAssessment> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectAssessment> findAll() {
		return this.em.createNamedQuery("ProjectAssessment.findAll", ProjectAssessment.class).getResultList();
	}

	@Override
	public List<ProjectAssessment> findByProjectsAndArchived(StudentProject studentProject, Boolean archived) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<ProjectAssessment> query = cb.createQuery(ProjectAssessment.class);
		Root<ProjectAssessment> pa = query.from(ProjectAssessment.class);
		query.select(pa);
		query.where(cb.and(cb.equal(pa.get(ProjectAssessment_.studentProject), studentProject), 
				cb.equal(pa.get(ProjectAssessment_.archived), Boolean.FALSE)));
		return em.createQuery(query).getResultList();
	}

}
