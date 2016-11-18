package com.bitwise.manageme.rssson.domain.grading;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import com.bitwise.manageme.rssson.domain.base.EducationalLength;
import com.bitwise.manageme.rssson.domain.base.Subject;

@Entity
@Indexed	
@Table(name="WEB_RSSSON_TRANSFER_CREDIT_TEMPLATE_COURSES")
@NamedQueries({
	@NamedQuery(name="TransferCreditTemplateCourse.findById", query="select distinct t from TransferCreditTemplateCourse t where t.id=:id"),
	@NamedQuery(name="TransferCreditTemplateCourse.findAll", query="select t from TransferCreditTemplateCourse t")
})
public class TransferCreditTemplateCourse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private TransferCreditTemplate transferCreditTemplate;
	
	private String courseName;
	
	private Integer courseCode;
	
	private String optionality;
	
	private Subject subject;
	
	private EducationalLength courseLength;

	@Id
	@DocumentId
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSFER_CREDIT_TEMPLATE_COURSE_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="TRANSFER_CREDIT_TEMPLATE_ID")
	public TransferCreditTemplate getTransferCreditTemplate() {
		return transferCreditTemplate;
	}

	public void setTransferCreditTemplate(TransferCreditTemplate transferCreditTemplate) {
		this.transferCreditTemplate = transferCreditTemplate;
	}

	@Field
	@Column(name="COURSE_NAME", nullable=false)
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name="COURSE_CODE")
	public Integer getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(Integer courseCode) {
		this.courseCode = courseCode;
	}

	@OneToOne
	@JoinColumn(name="EDUCATIONAL_LENGTH_ID")
	public EducationalLength getCourseLength() {
		return courseLength;
	}

	public void setCourseLength(EducationalLength courseLength) {
		this.courseLength = courseLength;
	}

	@Column(name="COURSE_OPTIONALITY", nullable=false)
	public String getOptionality() {
		return optionality;
	}

	public void setOptionality(String optionality) {
		this.optionality = optionality;
	}

	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
