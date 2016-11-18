package com.bitwise.manageme.rssson.repository.reports;
/**
 *  
 * @author Sika Kay
 * @date 22/06/16
 *
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitwise.manageme.rssson.domain.reports.Report;
import com.bitwise.manageme.rssson.domain.reports.ReportContextType;
import com.bitwise.manageme.rssson.domain.reports.Report_;

@Repository("reportRepository")
public class JpaReportRepository implements ReportRepository {

	final Logger logger = LoggerFactory.getLogger(JpaReportRepository.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Report report) {
		logger.info("Deleting report with ID " + report.getId());
		this.em.remove(report);
	}

	@Override
	public void delete(Iterable<? extends Report> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Report> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report findOne(Long id) {
		return this.em.createNamedQuery("Report.findById", Report.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends Report> S save(S report) {
		logger.info("Adding report with ID " + report.getId());
		return this.em.merge(report);
	}

	@Override
	public <S extends Report> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> findAll() {
		return this.em.createNamedQuery("Report.findAll", Report.class).getResultList();
	}

	@Override
	public List<Report> findByContextTypes(ReportContextType contextType) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Report> query = cb.createQuery(Report.class);
		Root<Report> report = query.from(Report.class);
		query.select(report);
		query.where(cb.equal(report.get(Report_.context), contextType));
		return em.createQuery(query).getResultList();
	}

}
