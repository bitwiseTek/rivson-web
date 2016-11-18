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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.accommodation.RoomType;
import com.bitwise.manageme.rssson.domain.accommodation.Room_;

@Repository("roomRepository")
public class JpaRoomRepository implements RoomRepository {

	final Logger logger = LoggerFactory.getLogger(JpaRoomRepository.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {

	}

	@Override
	public void delete(Room room) {
		logger.info("Deleting Room with ID " + room.getId());
		this.em.remove(room);
	}

	@Override
	public void delete(Iterable<? extends Room> arg0) {
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
	public Iterable<Room> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room findOne(Long id) {
		return this.em.createNamedQuery("Room.findById", Room.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends Room> S save(S room) {
		logger.info(("Adding room with ID " + room.getId()));
		return this.em.merge(room);
	}

	@Override
	public <S extends Room> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> findAll() {
		return this.em.createNamedQuery("Room.findAll", Room.class).getResultList();
	}

	@Override
	public List<Room> findByType(RoomType type) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Room> query = cb.createQuery(Room.class);
		Root<Room> room = query.from(Room.class);
		query.select(room);
		query.where(cb.equal(room.get(Room_.type), type));
		return em.createQuery(query).getResultList();
	}

}
