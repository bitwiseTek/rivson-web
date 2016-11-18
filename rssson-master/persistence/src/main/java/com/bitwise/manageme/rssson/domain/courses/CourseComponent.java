package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.PersistenceException;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.domain.base.CourseBase;

@Entity
@Table(name="WEB_RSSSON_COURSE_COMPONENTS")
@NamedQueries({
	@NamedQuery(name="CourseComponent.findById", query="select distinct c from CourseComponent c where c.id=:id"),
	@NamedQuery(name="CourseComponent.findAll", query="select c from CourseComponent c")
})
public class CourseComponent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Course course;
	
	private CourseBase courseBase;
	
	private List<CourseComponentResource> resources = new ArrayList<CourseComponentResource>();
	
	@Id
	@Column(name="COURSE_COMPONENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name="COURSE_BASE_ID")
	public CourseBase getCourseBase() {
		return courseBase;
	}

	public void setCourseBase(CourseBase courseBase) {
		this.courseBase = courseBase;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="COURSE_COMPONENT_RESOURCE_ID")
	public List<CourseComponentResource> getResources() {
		return resources;
	}

	public void setResources(List<CourseComponentResource> resources) {
		this.resources = resources;
	}
	
	public void addResource(CourseComponentResource resource) {
		if (!resources.contains(resource)) {
			if (resource.getCourseComponent() != null) {
				resource.getCourseComponent().removeResource(resource);
			}
			resource.setCourseComponent(this);
			resources.add(resource);
		} else {
			throw new PersistenceException("Component already contains this resource");
		}
	}
	
	public void removeResource(CourseComponentResource resource) {
		if (resources.contains(resource)) {
			resource.setCourseComponent(null);
			this.resources.remove(resource);
		} else {
			throw new PersistenceException("Component does not contain this resource");
		}
	}

}
