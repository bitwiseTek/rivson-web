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

import com.bitwise.manageme.rssson.domain.resources.Resource;

@Entity
@Table(name="WEB_RSSSON_COURSE_COMPONENT_RESOURCES")
@NamedQueries({
	@NamedQuery(name="CourseComponentResource.findById", query="select distinct c from CourseComponentResource c where c.id=:id"),
	@NamedQuery(name="CourseComponentResource.findAll", query="select c from CourseComponentResource c")
})
public class CourseComponentResource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CourseComponent courseComponent;
	
	private Resource resource;
	
	private Double usagePercent;

	@Id
	@Column(name="COURSE_COMPONENT_RESOURCE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_COMPONENT_ID")
	public CourseComponent getCourseComponent() {
		return courseComponent;
	}

	public void setCourseComponent(CourseComponent courseComponent) {
		this.courseComponent = courseComponent;
	}

	@ManyToOne
	@JoinColumn(name="RESOURCE_ID")
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Column(name="USAGE_PERCENT")
	public Double getUsagePercent() {
		return usagePercent;
	}

	public void setUsagePercent(Double usagePercent) {
		this.usagePercent = usagePercent;
	}
	
}
