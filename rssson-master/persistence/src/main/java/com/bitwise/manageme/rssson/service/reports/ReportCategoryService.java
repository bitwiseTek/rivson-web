package com.bitwise.manageme.rssson.service.reports;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import com.bitwise.manageme.rssson.domain.reports.ReportCategory;

public interface ReportCategoryService {

	public List<ReportCategory> findAll();
	
	public boolean isReportCategoryInUse(ReportCategory reportCategory);
	
	public ReportCategory save(ReportCategory reportCategory);
	
	public void delete(ReportCategory reportCategory);

}
