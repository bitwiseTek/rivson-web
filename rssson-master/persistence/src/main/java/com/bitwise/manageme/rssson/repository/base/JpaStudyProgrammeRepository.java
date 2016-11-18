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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.base.StudyProgramme;

@Repository("studyProgrammeRepository")
public class JpaStudyProgrammeRepository implements StudyProgrammeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaStudyProgrammeRepository.class);
	
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
	public void delete(StudyProgramme programme) {
		logger.info("Deleting study programme with ID " + programme.getId());
		this.em.remove(em.merge(programme));
	}

	@Override
	public void delete(Iterable<? extends StudyProgramme> arg0) {
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
	public Iterable<StudyProgramme> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudyProgramme findOne(Long id) {
		return this.em.createNamedQuery("StudyProgramme.findById", StudyProgramme.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends StudyProgramme> S save(S programme) {
		logger.info("Adding study programme with ID " + programme.getId());
		return this.em.merge(programme);
	}

	@Override
	public <S extends StudyProgramme> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudyProgramme> findAll() {
		return this.em.createNamedQuery("StudyProgramme.findAll", StudyProgramme.class).getResultList();
	}

	@Override
	public StudyProgramme findByName(String name) {
		TypedQuery<StudyProgramme> query = em.createNamedQuery("StudyProgramme.findByName", StudyProgramme.class).setParameter("name", name);
		List<StudyProgramme> programs = query.getResultList();
		return programs.size() == 1 ? programs.get(0) : null;
	}

	@Override
	public StudyProgramme findByCode(String code) {
		TypedQuery<StudyProgramme> query = em.createNamedQuery("StudyProgramme.findByCode", StudyProgramme.class).setParameter("code", code);
		List<StudyProgramme> programs = query.getResultList();
		return programs.size() == 1 ? programs.get(0) : null;
	}

}
