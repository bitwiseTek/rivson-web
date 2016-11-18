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

import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Table(name="WEB_RSSSON_COURSE_EDUCATION_SUBTYPES")
@NamedQueries({
	@NamedQuery(name="CourseEducationSubtype.findById", query="select distinct c from CourseEducationSubtype c where c.id=:id"),
	@NamedQuery(name="CourseEducationSubtype.findAll", query="select c from CourseEducationSubtype c")
})
public class CourseEducationSubtype implements Serializable {
	
	protected CourseEducationSubtype() {
		
	}
	
	public CourseEducationSubtype(EducationSubtype educationSubtype) {
		this.educationSubtype = educationSubtype;
	}

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CourseEducationType courseEducationType;
	
	private EducationSubtype educationSubtype;

	@Id
	@Column(name="COURSE_EDUCATION_SUBTYPE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_EDUCATION_TYPE_ID")
	public CourseEducationType getCourseEducationType() {
		return courseEducationType;
	}

	public void setCourseEducationType(CourseEducationType courseEducationType) {
		this.courseEducationType = courseEducationType;
	}

	@ManyToOne
	@IndexedEmbedded
	@JoinColumn(name="EDUCATION_SUBTYPE_ID", updatable=false)
	public EducationSubtype getEducationSubtype() {
		return educationSubtype;
	}

	public void setEducationSubtype(EducationSubtype educationSubtype) {
		this.educationSubtype = educationSubtype;
	}
}