package com.bitwise.manageme.rssson.service.help;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.help.StudentManual;

public interface StudentManualService {

	public StudentManual findById(Long id);
	
	public List<StudentManual> findAll();
	
	public StudentManual findByVersion(String manualVersion);
	
	public StudentManual save(StudentManual studentManual);
}
