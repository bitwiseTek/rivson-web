package com.bitwise.manageme.rssson.service.reports;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.reports.Report;
import com.bitwise.manageme.rssson.domain.reports.ReportContextType;

public interface ReportService {

	public List<Report> findAll();
	
	public List<Report> findByContextTypes(ReportContextType contextType);
	
	public Report save(Report report);
	
	public void delete(Report report);

}
