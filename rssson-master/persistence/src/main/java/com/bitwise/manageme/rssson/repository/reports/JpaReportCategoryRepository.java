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
import com.bitwise.manageme.rssson.domain.reports.ReportCategory;
import com.bitwise.manageme.rssson.domain.reports.Report_;

@Repository("reportCategoryRepository")
public class JpaReportCategoryRepository implements ReportCategoryRepository {

	final Logger logger = LoggerFactory.getLogger(JpaReportCategoryRepository.class);
	
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
	public void delete(ReportCategory reportCategory) {
		logger.info("Deleting report category with ID " + reportCategory.getId());
		this.em.remove(reportCategory);
	}

	@Override
	public void delete(Iterable<? extends ReportCategory> arg0) {
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
	public Iterable<ReportCategory> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReportCategory findOne(Long id) {
		return this.em.createNamedQuery("ReportCategory.findById", ReportCategory.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public <S extends ReportCategory> S save(S reportCategory) {
		logger.info("Adding report category with ID " + reportCategory.getId());
		return this.em.merge(reportCategory);
	}

	@Override
	public <S extends ReportCategory> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportCategory> findAll() {
		return this.em.createNamedQuery("ReportCategory.findAll", ReportCategory.class).getResultList();
	}

	@Override
	public boolean isReportCategoryInUse(ReportCategory reportCategory) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<Report> reportCat = query.from(Report.class);
		query.select(cb.count(reportCat));
		query.where(cb.equal(reportCat.get(Report_.category), reportCategory));
		return em.createQuery(query).getSingleResult() > 0;
	}

}
