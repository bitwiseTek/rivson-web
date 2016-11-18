package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Table(name="WEB_RSSSON_COURSE_EDUCATION_TYPES")
@NamedQueries({
	@NamedQuery(name="CourseEducationType.findById", query="select distinct c from CourseEducationType c where c.id=:id"),
	@NamedQuery(name="CourseEducationType.findAll", query="select c from CourseEducationType c")
})
public class CourseEducationType implements Serializable {
	
	protected CourseEducationType() {
		
	}
	
	public CourseEducationType(EducationType educationType) {
		setEducationType(educationType);
	}

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CourseBase courseBase;
	
	private EducationType educationType;
	
	private List<CourseEducationSubtype> courseEducationSubtypes = new Vector<CourseEducationSubtype>();

	@Id
	@Column(name="COURSE_EDUCATION_TYPE_ID")
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
	@IndexedEmbedded
	@JoinColumn(name="EDUCATION_TYPE_ID")
	public EducationType getEducationType() {
		return educationType;
	}

	public void setEducationType(EducationType educationType) {
		this.educationType = educationType;
	}

	@IndexedEmbedded
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<CourseEducationSubtype> getCourseEducationSubtypes() {
		return courseEducationSubtypes;
	}

	public void setCourseEducationSubtypes(List<CourseEducationSubtype> courseEducationSubtypes) {
		this.courseEducationSubtypes = courseEducationSubtypes;
	}
}
