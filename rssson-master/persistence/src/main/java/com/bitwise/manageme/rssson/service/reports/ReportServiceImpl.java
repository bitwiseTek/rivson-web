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
import com.bitwise.manageme.rssson.domain.reports.ReportContextType;
import com.bitwise.manageme.rssson.repository.reports.ReportRepository;
import com.google.common.collect.Lists;

@Transactional
@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository reportRepo;
	
	@Override
	@Transactional(readOnly=true)
	public List<Report> findAll() {
		return Lists.newArrayList(this.reportRepo.findAll());
	}

	@Override
	@Transactional(readOnly=true)
	public List<Report> findByContextTypes(ReportContextType contextType) {
		return this.reportRepo.findByContextTypes(contextType);
	}

	@Override
	@Transactional(readOnly=false)
	public Report save(Report report) {
		return this.reportRepo.save(report);
	}

	@Override
	public void delete(Report report) {
		this.reportRepo.delete(report);
	}

}
