package com.bitwise.manageme.rssson.domain.reports;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="WEB_RSSSON_REPORT_CONTEXTS")
@NamedQueries({
	@NamedQuery(name="ReportContext.findById", query="select distinct r from ReportContext r where r.id=:id"),
	@NamedQuery(name="ReportContext.findAll", query="select r from ReportContext r")
})
public class ReportContext implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Report report;
	
	private ReportContextType context;

	@Id
	@Column(name="REPORT_CONTEXT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="REPORT_ID")
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="REPORT_CONTEXT_TYPE", insertable=true, updatable=false, nullable=false)
	public ReportContextType getContext() {
		return context;
	}

	public void setContext(ReportContextType context) {
		this.context = context;
	}

}
