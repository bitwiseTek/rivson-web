package com.bitwise.manageme.rssson.service.reports;
/**
 *  
 * @author Sika Kay
 * @date 29/06/16
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitwise.manageme.rssson.domain.reports.ReportCategory;
import com.bitwise.manageme.rssson.repository.reports.ReportCategoryRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("reportCateoryService")
public class ReportCategoryServiceImpl implements ReportCategoryService {

	@Autowired
	private ReportCategoryRepository reportCategoryRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<ReportCategory> findAll() {
		return Lists.newArrayList(this.reportCategoryRepo.findAll());
	}

	@Override
	public boolean isReportCategoryInUse(ReportCategory reportCategory) {
		return this.reportCategoryRepo.isReportCategoryInUse(reportCategory);
	}

	@Override
	@Transactional(readOnly=false)
	public ReportCategory save(ReportCategory reportCategory) {
		return this.reportCategoryRepo.save(reportCategory);
	}

	@Override
	public void delete(ReportCategory reportCategory) {
		this.reportCategoryRepo.delete(reportCategory);
	}

}
