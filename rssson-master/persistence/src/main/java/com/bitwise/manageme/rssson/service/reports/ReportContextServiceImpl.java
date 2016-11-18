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

import com.bitwise.manageme.rssson.domain.reports.Report;
import com.bitwise.manageme.rssson.domain.reports.ReportContext;
import com.bitwise.manageme.rssson.domain.reports.ReportContextType;
import com.bitwise.manageme.rssson.repository.reports.ReportContextRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("reportContextService")
public class ReportContextServiceImpl implements ReportContextService {

	@Autowired
	private ReportContextRepository reportContextRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<ReportContext> findAll() {
		return Lists.newArrayList(this.reportContextRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public ReportContext findByReportAndContextType(Report report, ReportContextType contextType) {
		return this.reportContextRepo.findByReportAndContextType(report, contextType);
	}

	@Override
	@Transactional(readOnly=true)
	public ReportContext findByReport(Report report) {
		return this.findByReport(report);
	}

	@Override
	@Transactional(readOnly=false)
	public ReportContext save(ReportContext reportContext) {
		return this.reportContextRepo.save(reportContext);
	}

	@Override
	public void delete(ReportContext reportContext) {
		this.reportContextRepo.delete(reportContext);
	}

}
