package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
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
import javax.persistence.Table;

import com.bitwise.manageme.rssson.domain.courses.CourseState;

@Entity
@Table(name="WEB_RSSSON_DEFAULTS")
@NamedQueries({
	@NamedQuery(name="Defaults.findById", query="select distinct d from Defaults d where d.id=:id"),
	@NamedQuery(name="Defaults.findAll", query="select d from Defaults d")
})
public class Defaults implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private EducationalTimeUnit baseTimeUnit;
	
	private CourseState initialCourseState;
	
	private String initialCourseEnrolmentType;
	
	private String initialCourseParticipationType;

	@Id
	@Column(name="DEFAULT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="EDUCATIONAL_TIME_LIMIT_ID")
	public EducationalTimeUnit getBaseTimeUnit() {
		return baseTimeUnit;
	}

	public void setBaseTimeUnit(EducationalTimeUnit baseTimeUnit) {
		this.baseTimeUnit = baseTimeUnit;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_STATE_ID")
	public CourseState getInitialCourseState() {
		return initialCourseState;
	}

	public void setInitialCourseState(CourseState initialCourseState) {
		this.initialCourseState = initialCourseState;
	}

	@Column(name="COURSE_ENROLMENT_TYPE", nullable=false)
	public String getInitialCourseEnrolmentType() {
		return initialCourseEnrolmentType;
	}

	public void setInitialCourseEnrolmentType(String initialCourseEnrolmentType) {
		this.initialCourseEnrolmentType = initialCourseEnrolmentType;
	}

	@Column(name="COURSE_PARTICIPATION_TYPE_ID", nullable=false)
	public String getInitialCourseParticipationType() {
		return initialCourseParticipationType;
	}

	public void setInitialCourseParticipationType(String initialCourseParticipationType) {
		this.initialCourseParticipationType = initialCourseParticipationType;
	}
}
