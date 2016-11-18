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

@Entity
@Table(name="WEB_RSSSON_COURSE_BASE_VARIABLES")
@NamedQueries({
	@NamedQuery(name="CourseBaseVariable.findById", query="select distinct c from CourseBaseVariable c where c.id=:id"),
	@NamedQuery(name="CourseBaseVariable.findAll", query="select c from CourseBaseVariable c")
})
public class CourseBaseVariable implements Serializable {
	
	public CourseBaseVariable() {
		super();
	}

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CourseBase courseBase;
	
	private CourseBaseVariableKey key;
	
	private String value;

	@Id
	@Column(name="COURSE_BASE_VARIABLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_BASE_ID")
	public CourseBase getCourseBase() {
		return courseBase;
	}

	public void setCourseBase(CourseBase courseBase) {
		this.courseBase = courseBase;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_BASE_VARIABLE_KEY_ID")
	public CourseBaseVariableKey getKey() {
		return key;
	}

	public void setKey(CourseBaseVariableKey key) {
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
