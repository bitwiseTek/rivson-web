package com.bitwise.manageme.rssson.repository.accommodation;
/**
 *  
 * @author Sika Kay
 * @date 20/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.accommodation.RoomType;

public interface RoomRepository extends CrudRepository<Room, Long> {

	public List<Room> findAll();
	
	public List<Room> findByType(RoomType type);
	
}
