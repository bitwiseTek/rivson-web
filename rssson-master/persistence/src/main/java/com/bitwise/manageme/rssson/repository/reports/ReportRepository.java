package com.bitwise.manageme.rssson.repository.reports;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.reports.Report;
import com.bitwise.manageme.rssson.domain.reports.ReportContextType;

public interface ReportRepository extends CrudRepository<Report, Long> {

	public List<Report> findAll();
	
	public List<Report> findByContextTypes(ReportContextType contextType);
}
