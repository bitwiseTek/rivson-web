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
import com.bitwise.manageme.rssson.domain.reports.ReportContext;
import com.bitwise.manageme.rssson.domain.reports.ReportContextType;

public interface ReportContextRepository extends CrudRepository<ReportContext, Long> {

	public List<ReportContext> findAll();
	
	public ReportContext findByReportAndContextType(Report report, ReportContextType contextType);
	
	public ReportContext findByReport(Report report);
}
