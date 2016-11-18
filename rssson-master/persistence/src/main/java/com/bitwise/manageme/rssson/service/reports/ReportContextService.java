package com.bitwise.manageme.rssson.service.reports;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.reports.Report;
import com.bitwise.manageme.rssson.domain.reports.ReportContext;
import com.bitwise.manageme.rssson.domain.reports.ReportContextType;

public interface ReportContextService {

	public List<ReportContext> findAll();
	
	public ReportContext findByReportAndContextType(Report report, ReportContextType contextType);
	
	public ReportContext findByReport(Report report);
	
	public ReportContext save(ReportContext reportContext);
	
	public void delete(ReportContext reportContext);

}
