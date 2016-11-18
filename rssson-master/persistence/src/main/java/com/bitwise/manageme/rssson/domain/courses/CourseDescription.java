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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.domain.base.CourseBase;

@Entity
@Table(name="WEB_RSSSON_COURSE_DESCRIPTIONS")
@NamedQueries({
	@NamedQuery(name="CourseDescription.findById", query="select distinct c from CourseDescription c where c.id=:id"),
	@NamedQuery(name="CourseDescription.findAll", query="select c from CourseDescription c")
})
public class CourseDescription implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CourseBase courseBase;
	
	private String description;

	@Id
	@Column(name="COURSE_DESCRIPTION_ID")
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

	@Lob
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
