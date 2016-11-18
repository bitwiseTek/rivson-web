package com.bitwise.manageme.rssson.service.help;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.help.StaffManual;
import com.bitwise.manageme.rssson.repository.help.StaffManualRepository;

@Transactional
@Service("staffManualService")
public class StaffManualServiceImpl implements StaffManualService {

	@Autowired
	private StaffManualRepository staffManualRepo;
	
	@Override
	@Transactional(readOnly=true)
	public StaffManual findById(Long id) {
		return this.staffManualRepo.findOne(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<StaffManual> findAll() {
		return this.staffManualRepo.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public StaffManual findByVersion(String manualVersion) {
		return this.staffManualRepo.findByVersion(manualVersion);
	}

	@Override
	@Transactional(readOnly=false)
	public StaffManual save(StaffManual staffManual) {
		return this.staffManualRepo.save(staffManual);
	}

}
