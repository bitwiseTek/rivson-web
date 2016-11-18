package com.bitwise.manageme.rssson.repository.file;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.file.File;

@Repository("fileRepository")
public class JpaFileRepository implements FileRepository {

	final Logger logger = LoggerFactory.getLogger(JpaFileRepository.class);
	
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
	public void delete(File arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends File> arg0) {
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
	public Iterable<File> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File findOne(Long id) {
		return this.em.createNamedQuery("File.findById", File.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends File> S save(S file) {
		logger.info("Adding file with ID " + file.getId());
		return this.em.merge(file);
	}

	@Override
	public <S extends File> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File> findAll() {
		return this.em.createNamedQuery("File.findAll", File.class).getResultList();
	}

}
