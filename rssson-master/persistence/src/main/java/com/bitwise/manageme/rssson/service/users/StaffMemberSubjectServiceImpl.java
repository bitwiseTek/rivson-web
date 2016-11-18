package com.bitwise.manageme.rssson.service.users;
/**
 *  
 * @author Sika Kay
 * @date 28/09/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.users.StaffMemberSubject;
import com.bitwise.manageme.rssson.repository.users.StaffMemberSubjectRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("staffMemberSubjectService")
public class StaffMemberSubjectServiceImpl implements StaffMemberSubjectService {

	@Autowired
	private StaffMemberSubjectRepository staffSubjectRepo;

	@Override
	@Transactional(readOnly=true)
	public List<StaffMemberSubject> findAll() {
		return Lists.newArrayList(this.staffSubjectRepo.findAll());
	}

	@Override
	@Transactional(readOnly=false)
	public StaffMemberSubject save(StaffMemberSubject staffSubject) {
		return this.staffSubjectRepo.save(staffSubject);
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(StaffMemberSubject staffSubject) {
		this.staffSubjectRepo.delete(staffSubject);
	}

	@Override
	@Transactional(readOnly=true)
	public StaffMemberSubject findById(Long id) {
		return this.staffSubjectRepo.findOne(id);
	}

}
