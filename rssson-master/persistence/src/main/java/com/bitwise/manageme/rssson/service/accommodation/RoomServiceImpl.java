package com.bitwise.manageme.rssson.service.accommodation;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.accommodation.RoomType;
import com.bitwise.manageme.rssson.repository.accommodation.RoomRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepo;
	
	@Transactional(readOnly=true)
	public List<Room> findAll() {
		return Lists.newArrayList(this.roomRepo.findAll());
	}

	@Transactional(readOnly=true)
	public List<Room> findByType(RoomType type) {
		return this.roomRepo.findByType(type);
	}

	public void delete(Room room) {
		this.roomRepo.delete(room);
	}

	@Transactional(readOnly=false)
	public Room save(Room room) {
		return this.roomRepo.save(room);
	}

	@Override
	@Transactional(readOnly=true)
	public Room findById(Long id) {
		return this.roomRepo.findOne(id);
	}

}
