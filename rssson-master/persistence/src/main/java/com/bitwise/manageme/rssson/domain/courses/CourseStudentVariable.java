package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
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

@Entity
@Table(name="WEB_RSSSON_COURSE_STUDENT_VARIABLES")
@NamedQueries({
	@NamedQuery(name="CourseStudentVariable.findById", query="select distinct c from CourseStudentVariable c where c.id=:id"),
	@NamedQuery(name="CourseStudentVariable.findAll", query="select c from CourseStudentVariable c")
})
public class CourseStudentVariable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CourseStudent courseStudent;
	
	private CourseStudentVariableKey key;
	
	private String value;

	@Id
	@Column(name="COURSE_STUDENT_VARIABLE_ID")
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

	@ManyToOne
	@JoinColumn(name="COURSE_STUDENT_VARIABLE_KEY_ID")
	public CourseStudentVariableKey getKey() {
		return key;
	}

	public void setKey(CourseStudentVariableKey key) {
		this.key = key;
	}

	@Column(name="VALUE")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
