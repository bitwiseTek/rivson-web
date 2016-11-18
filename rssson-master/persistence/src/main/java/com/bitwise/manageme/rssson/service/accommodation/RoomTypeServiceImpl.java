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

import com.bitwise.manageme.rssson.domain.accommodation.RoomType;
import com.bitwise.manageme.rssson.repository.accommodation.RoomTypeRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("roomTypeService")
public class RoomTypeServiceImpl implements RoomTypeService {

	@Autowired
	private RoomTypeRepository roomTypeRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<RoomType> findAll() {
		return Lists.newArrayList(this.roomTypeRepo.findAll());
	}

	@Override
	public void delete(RoomType roomType) {
		this.roomTypeRepo.delete(roomType);
	}

	@Override
	@Transactional(readOnly=false)
	public RoomType save(RoomType roomType) {
		return this.roomTypeRepo.save(roomType);
	}

}
