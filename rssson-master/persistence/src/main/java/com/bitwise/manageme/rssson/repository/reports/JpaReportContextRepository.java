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
import com.bitwise.manageme.rssson.domain.reports.ReportContext;
import com.bitwise.manageme.rssson.domain.reports.ReportContextType;
import com.bitwise.manageme.rssson.domain.reports.ReportContext_;

@Repository("reportContextRepository")
public class JpaReportContextRepository implements ReportContextRepository {

	final Logger logger = LoggerFactory.getLogger(JpaReportContextRepository.class);
	
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
	public void delete(ReportContext reportContext) {
		logger.info("Deleting report context with ID " + reportContext.getId());
		this.em.remove(reportContext);
	}

	@Override
	public void delete(Iterable<? extends ReportContext> arg0) {
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
	public Iterable<ReportContext> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportContext findOne(Long id) {
		return this.em.createNamedQuery("ReportContext.findById", ReportContext.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends ReportContext> S save(S reportContext) {
		logger.info("Adding report context with ID " + reportContext.getId());
		return this.em.merge(reportContext);
	}

	@Override
	public <S extends ReportContext> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportContext> findAll() {
		return this.em.createNamedQuery("ReportContext.findAll", ReportContext.class).getResultList();
	}

	@Override
	public ReportContext findByReportAndContextType(Report report, ReportContextType contextType) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<ReportContext> query = cb.createQuery(ReportContext.class);
		Root<ReportContext> reportContext = query.from(ReportContext.class);
		query.select(reportContext);
		query.where(cb.and(cb.equal(reportContext.get(ReportContext_.report), report), 
				cb.equal(reportContext.get(ReportContext_.context), contextType)));
		return em.createQuery(query).getSingleResult();
	}

	@Override
	public ReportContext findByReport(Report report) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<ReportContext> query = cb.createQuery(ReportContext.class);
		Root<ReportContext> reportContext = query.from(ReportContext.class);
		query.select(reportContext);
		query.where(cb.equal(reportContext.get(ReportContext_.report), report));
		return em.createQuery(query).getSingleResult();
	}

}
