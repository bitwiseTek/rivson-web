package com.bitwise.manageme.rssson.domain.grading;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.domain.students.Student;

@Entity
@PrimaryKeyJoinColumn(name="CREDIT_ID")
@Table(name="WEB_RSSSON_COURSE_ASSESSMENTS")
@NamedQueries({
	@NamedQuery(name="CourseAssessment.findById", query="select distinct c from CourseAssessment c where c.id=:id"),
	@NamedQuery(name="CourseAssessment.findAll", query="select c from CourseAssessment c")
})
public class CourseAssessment extends Credit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public CourseAssessment() {
		super();
		setCreditType(CreditType.CourseAssessment);
	}
	
	private CourseStudent courseStudent;
	
	@Transient
	public Student getStudent() {
		return courseStudent != null ? courseStudent.getStudent() : null;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_STUDENT_ID", unique=true)
	public CourseStudent getCourseStudent() {
		return courseStudent;
	}

	public void setCourseStudent(CourseStudent courseStudent) {
		this.courseStudent = courseStudent;
	}
}
