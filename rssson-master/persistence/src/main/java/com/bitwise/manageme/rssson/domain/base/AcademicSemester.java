package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Field;

@Entity
@Table(name="WEB_RSSSON_ACADEMIC_SEMESTER")
@NamedQueries({
	@NamedQuery(name="AcademicSemester.findById", query="select distinct a from AcademicSemester a where a.id=:id"),
	@NamedQuery(name="AcademicSemester.findAll", query="select a from AcademicSemester a")
})
public class AcademicSemester implements Serializable, ArchivableEntity {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String session;
	
	private Date startDate;
	
	private Date endDate;
	
	private Boolean archived = Boolean.FALSE;

	@Id
	@Column(name="SEMESTER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="SEMESTER_NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="ACADEMIC_SESSION", nullable=false)
	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="SEMESTER_START_DATE", nullable=false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="SEMESTER_END_DATE", nullable=false)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Field
	@Column(name="ARCHIVED", nullable=false)
	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

}
