package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
import com.bitwise.manageme.rssson.util.usertypes.MonetaryAmount;

@Entity
@Table(name="WEB_RSSSON_BASIC_COURSE_RESOURCES")
@NamedQueries({
	@NamedQuery(name="BasicCourseResource.findById", query="select distinct b from BasicCourseResource b where b.id=:id"),
	@NamedQuery(name="BasicCourseResource.findAll", query="select b from BasicCourseResource b")
})
public class BasicCourseResource implements Serializable {

	protected BasicCourseResource() {
		
	}
	
	public BasicCourseResource(Course course, Resource resource) {
		setCourse(course);
		setResource(resource);
	}
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Course course;
	
	private Resource resource;
	
	private Double hours;
	
	private MonetaryAmount hourlyCost;
	
	private Integer units;
	
	private MonetaryAmount unitCost;
	
	@Id
	@Column(name="BASIC_COURSE_RESOURCE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne
	@JoinColumn(name="RESOURCE_ID")
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Column(name="HOURS", nullable=false)
	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	@Column(name="HOURLY_COST", nullable=false)
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "hourly_cost_amount")),
        @AttributeOverride(name = "currency", column = @Column(name = "hourly_cost_currency"))})
	public MonetaryAmount getHourlyCost() {
		return hourlyCost;
	}

	public void setHourlyCost(MonetaryAmount hourlyCost) {
		this.hourlyCost = hourlyCost;
	}
	
	@Column(name="UNITS", nullable=false)
	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	@Column(name="UNIT_COST", nullable=false)
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "unit_cost_amount")),
        @AttributeOverride(name = "currency", column = @Column(name = "unit_cost_currency"))})
	public MonetaryAmount getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(MonetaryAmount unitCost) {
		this.unitCost = unitCost;
	}

}
