package com.bitwise.manageme.rssson.repository.accommodation;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.accommodation.RoomType;

@Repository("roomTypeRepository")
public class JpaRoomTypeRepository implements RoomTypeRepository {

	final Logger logger = LoggerFactory.getLogger(JpaRoomTypeRepository.class);
	
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
	public void delete(RoomType roomType) {
		logger.info("Deleting room type with ID " + roomType.getId());
		this.em.remove(roomType);
	}

	@Override
	public void delete(Iterable<? extends RoomType> arg0) {
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
	public Iterable<RoomType> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomType findOne(Long id) {
		return this.em.createNamedQuery("RoomType.findById", RoomType.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends RoomType> S save(S roomType) {
		logger.info("Adding room type with ID " + roomType.getId());
		return this.em.merge(roomType);
	}

	@Override
	public <S extends RoomType> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomType> findAll() {
		return this.em.createNamedQuery("RoomType.findAll", RoomType.class).getResultList();
	}

}
