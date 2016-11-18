package com.bitwise.manageme.rssson.service.accommodation;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.accommodation.RoomType;

public interface RoomTypeService {
	
	public List<RoomType> findAll();
	
	public void delete(RoomType roomType);
	
	public RoomType save(RoomType roomType);

}
