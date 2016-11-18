package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 29/09/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.users.StaffMember;
import com.bitwise.manageme.rssson.domain.users.StaffMemberImage;
import com.bitwise.manageme.rssson.repository.users.StaffMemberImageRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("staffImageService")
public class StaffMemberImageServiceImpl implements StaffMemberImageService {

	@Autowired
	private StaffMemberImageRepository staffImageRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<StaffMemberImage> findAll() {
		return Lists.newArrayList(this.staffImageRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public StaffMemberImage findById(Long id) {
		return this.staffImageRepo.findOne(id);
	}

	@Override
	public StaffMemberImage findByStaff(StaffMember student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean findStaffHasImage(StaffMember student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaffMemberImage save(StaffMemberImage image) {
		return this.staffImageRepo.save(image);
	}

	@Override
	public void delete(StaffMemberImage image) {
		this.staffImageRepo.delete(image);
	}

}
