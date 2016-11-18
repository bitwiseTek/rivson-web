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

import com.bitwise.manageme.rssson.domain.file.FileType;

@Repository("fileTypeRepository")
public class JpaFileTypeRepository implements FileTypeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaFileTypeRepository.class);
	
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
	public void delete(FileType arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends FileType> arg0) {
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
	public Iterable<FileType> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileType findOne(Long id) {
		return this.em.createNamedQuery("FileType.findById", FileType.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends FileType> S save(S fileType) {
		logger.info("Adding file type with ID " + fileType.getId());
		return this.em.merge(fileType);
	}

	@Override
	public <S extends FileType> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileType> findAll() {
		return this.em.createNamedQuery("FileType.findAll", FileType.class).getResultList();

	}

}
