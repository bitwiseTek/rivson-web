package com.bitwise.manageme.rssson.domain.grading;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.domain.users.StaffMember;

@Entity
@Table(name="WEB_RSSSON_CREDITS")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name="Credit.findById", query="select distinct c from Credit c where c.id=:id"),
	@NamedQuery(name="Credit.findAll", query="select c from Credit c")
})
public class Credit implements ArchivableEntity, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Date date;
	
	private Grade grade;
	
	private String verbalAssessment;
	
	private StaffMember assessor;
	
	private Boolean archived = Boolean.FALSE;
	
	private CreditType creditType;
	
	@Id
	@Column(name="CREDIT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="DATE", nullable=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToOne
	@JoinColumn(name="GRADE_ID")
	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="VERBAL_ASSESSMENT")
	public String getVerbalAssessment() {
		return verbalAssessment;
	}

	public void setVerbalAssessment(String verbalAssessment) {
		this.verbalAssessment = verbalAssessment;
	}

	@ManyToOne
	@JoinColumn(name="STAFF_MEMBER_ID")
	public StaffMember getAssessor() {
		return assessor;
	}

	public void setAssessor(StaffMember assessor) {
		this.assessor = assessor;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="CREDIT_TYPE", insertable=true, updatable=false, nullable=false)
	public CreditType getCreditType() {
		return creditType;
	}

	public void setCreditType(CreditType creditType) {
		this.creditType = creditType;
	}

	@Override
	@Column(name="ARCHIVED", nullable=false)
	public Boolean getArchived() {
		return archived;
	}

	@Override
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

}
