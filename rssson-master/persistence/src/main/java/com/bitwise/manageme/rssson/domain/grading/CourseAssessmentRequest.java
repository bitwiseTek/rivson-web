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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.search.annotations.Field;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.students.Student;

@Entity
@Table(name="WEB_RSSSON_COURSE_ASSESSMENT_REQUESTS")
@NamedQueries({
	@NamedQuery(name="CourseAssessmentRequest.findById", query="select distinct c from CourseAssessmentRequest c where c.id=:id"),
	@NamedQuery(name="CourseAssessmentRequest.findAll", query="select c from CourseAssessmentRequest c")
})
public class CourseAssessmentRequest implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private CourseStudent courseStudent;
	
	private Date created;
	
	private String requestText;
	
	private Boolean archived = Boolean.FALSE;

	@Id
	@Column(name="COURSE_ASSESSMENT_REQUEST_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_STUDENT_ID")
	public CourseStudent getCourseStudent() {
		return courseStudent;
	}

	public void setCourseStudent(CourseStudent courseStudent) {
		this.courseStudent = courseStudent;
	}
	
	@Transient
	public Student getStudent() {
		return courseStudent != null ? courseStudent.getStudent() : null;
	}

	@Column(name="CREATED_DATE")
	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="REQUEST_TEXT")
	public String getRequestText() {
		return requestText;
	}

	public void setRequestText(String requestText) {
		this.requestText = requestText;
	}

	@Field
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
