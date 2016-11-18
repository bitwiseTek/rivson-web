package com.bitwise.manageme.rssson.service.accommodation;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.accommodation.Room;
import com.bitwise.manageme.rssson.domain.accommodation.RoomType;

public interface RoomService {

	public List<Room> findAll();
	
	public Room findById(Long id);
	
	public List<Room> findByType(RoomType type);
	
	public void delete(Room room);
	
	public Room save(Room room);
	
}
