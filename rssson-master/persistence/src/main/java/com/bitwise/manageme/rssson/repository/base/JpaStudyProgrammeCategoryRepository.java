package com.bitwise.manageme.rssson.repository.base;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.StudyProgrammeCategory;

@Repository("studyProgrammeCategoryRepository")
public class JpaStudyProgrammeCategoryRepository implements StudyProgrammeCategoryRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudyProgrammeCategoryRepository.class);
	
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
	@Transactional
	public void delete(StudyProgrammeCategory category) {
		logger.info("Deleting study programme category with ID " + category.getId());
		this.em.remove(em.merge(category));
	}

	@Override
	public void delete(Iterable<? extends StudyProgrammeCategory> arg0) {
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
	public Iterable<StudyProgrammeCategory> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudyProgrammeCategory findOne(Long id) {
		return this.em.createNamedQuery("StudyProgrammeCategory.findById", StudyProgrammeCategory.class).setParameter("id", id).getSingleResult();
	}

	@Override
	@Transactional
	public <S extends StudyProgrammeCategory> S save(S category) {
		logger.info("Adding study programme category with ID " + category.getId());
		return this.em.merge(category);
	}

	@Override
	public <S extends StudyProgrammeCategory> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudyProgrammeCategory> findAll() {
		return this.em.createNamedQuery("StudyProgrammeCategory.findAll", StudyProgrammeCategory.class).getResultList();
	}

	@Override
	public StudyProgrammeCategory findByName(String name) {
		TypedQuery<StudyProgrammeCategory> query = em.createNamedQuery("StudyProgrammeCategory.findByName", StudyProgrammeCategory.class).setParameter("name", name);
		List<StudyProgrammeCategory> categories = query.getResultList();
		return categories.size() == 1 ? categories.get(0) : null;
	}

}
