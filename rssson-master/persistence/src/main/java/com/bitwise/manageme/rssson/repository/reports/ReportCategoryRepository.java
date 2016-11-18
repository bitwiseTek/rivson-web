package com.bitwise.manageme.rssson.repository.reports;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitwise.manageme.rssson.domain.reports.ReportCategory;

public interface ReportCategoryRepository extends CrudRepository<ReportCategory, Long> {

	public List<ReportCategory> findAll();
	
	public boolean isReportCategoryInUse(ReportCategory reportCategory);
}
