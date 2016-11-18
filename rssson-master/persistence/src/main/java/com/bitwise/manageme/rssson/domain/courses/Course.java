package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
 *
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.validator.constraints.NotEmpty;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory;

@Entity
@Indexed
@Table(name="WEB_RSSSON_COURSES", uniqueConstraints = @UniqueConstraint(columnNames = {
"course_name" }))
@FullTextFilterDefs(
	@FullTextFilterDef(
		name="ArchivedCourse", 
		impl=ArchivedEntityFilterFactory.class
	)
)
@NamedQueries({
	@NamedQuery(name="Course.findById", query="select distinct c from Course c where c.id=:id"),
	@NamedQuery(name="Course.findByName", query="select distinct c from Course c where c.name=:name"),
	@NamedQuery(name="Course.findAll", query="select c from Course c")
})
public class Course implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CourseState state;
	
	private CourseBase courseBase;
	
	private CourseType type;
	
	private String name;
	
	private Date beginDate;
	
	private Date endDate;
	
	private Double distanceTeachingDays;
	
	private Double distanceTeachingHours;
	
	private Double planningHours;
	
	private Double localTeachingDays;
	
	private Double localTeachingHours;
	
	private Double assessingHours;
	
	private Date enrolmentTimeEnd;
	
	private BigDecimal courseFee;
	
	private Currency courseFeeCurrency;
	
	private Boolean archived = Boolean.FALSE; 
	
	private List<CourseComponent> courseComponents = new Vector<CourseComponent>();
	
	private List<BasicCourseResource> basicCourseResources = new Vector<BasicCourseResource>();
	
	private List<StudentCourseResource> studentCourseResources = new Vector<StudentCourseResource>();
	
	private List<GradeCourseResource> gradeCourseResources = new Vector<GradeCourseResource>();
	
	private List<OtherCost> otherCosts = new Vector<OtherCost>();
	
	@Id
	@Column(name="COURSE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@IndexedEmbedded
	@JoinColumn(name="COURSE_STATE_ID")
	public CourseState getState() {
		return state;
	}

	public void setState(CourseState state) {
		this.state = state;
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
	@JoinColumn(name="COURSE_TYPE_ID")
	public CourseType getType() {
		return type;
	}

	public void setType(CourseType type) {
		this.type = type;
	}

	@Field
	@NotEmpty
	@Column(name="COURSE_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Field(analyze=Analyze.NO)
	@Column(name="BEGIN_DATE")
	@Temporal(value=TemporalType.DATE)
	@DateBridge(resolution=Resolution.DAY)
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Field(analyze=Analyze.NO)
	@Column(name="END_DATE")
	@Temporal(value=TemporalType.DATE)
	@DateBridge(resolution=Resolution.DAY)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getDistanceTeachingDays() {
		return distanceTeachingDays;
	}

	public void setDistanceTeachingDays(Double distanceTeachingDays) {
		this.distanceTeachingDays = distanceTeachingDays;
	}

	public Double getDistanceTeachingHours() {
		return distanceTeachingHours;
	}

	public void setDistanceTeachingHours(Double distanceTeachingHours) {
		this.distanceTeachingHours = distanceTeachingHours;
	}

	public Double getPlanningHours() {
		return planningHours;
	}

	public void setPlanningHours(Double planningHours) {
		this.planningHours = planningHours;
	}

	public Double getLocalTeachingDays() {
		return localTeachingDays;
	}

	public void setLocalTeachingDays(Double localTeachingDays) {
		this.localTeachingDays = localTeachingDays;
	}

	public Double getLocalTeachingHours() {
		return localTeachingHours;
	}

	public void setLocalTeachingHours(Double localTeachingHours) {
		this.localTeachingHours = localTeachingHours;
	}

	public Double getAssessingHours() {
		return assessingHours;
	}

	public void setAssessingHours(Double assessingHours) {
		this.assessingHours = assessingHours;
	}

	@IndexedEmbedded
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<CourseComponent> getCourseComponents() {
		return courseComponents;
	}

	public void setCourseComponents(List<CourseComponent> courseComponents) {
		this.courseComponents = courseComponents;
	}
	
	public void addCourseComponent(CourseComponent courseComponent) {
		if (courseComponent.getCourse() != null) {
			courseComponent.getCourse().getCourseComponents().remove(courseComponent);
		}
		courseComponent.setCourse(this);
		courseComponents.add(courseComponent);
	}
	
	public void removeCourseComponent(CourseComponent courseComponent) {
		courseComponent.setCourse(null);
		this.courseComponents.remove(courseComponent);
	}

	@IndexedEmbedded
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<BasicCourseResource> getBasicCourseResources() {
		return basicCourseResources;
	}

	public void setBasicCourseResources(List<BasicCourseResource> basicCourseResources) {
		this.basicCourseResources = basicCourseResources;
	}
	
	public void addBasicCourseResource(BasicCourseResource basicCourseResource) {
		if (basicCourseResource.getCourse() != null) {
			basicCourseResource.getCourse().getBasicCourseResources().remove(basicCourseResource);
		}
		basicCourseResource.setCourse(this);
		basicCourseResources.add(basicCourseResource);
	}
	
	public void removeBasicCourseResource(BasicCourseResource basicCourseResource) {
		basicCourseResource.setCourse(null);
		this.basicCourseResources.remove(basicCourseResource);
	}

	@IndexedEmbedded
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<StudentCourseResource> getStudentCourseResources() {
		return studentCourseResources;
	}

	public void setStudentCourseResources(List<StudentCourseResource> studentCourseResources) {
		this.studentCourseResources = studentCourseResources;
	}
	
	public void addStudentCourseResource(StudentCourseResource studentCourseResource) {
		if (studentCourseResource.getCourse() != null) {
			studentCourseResource.getCourse().getStudentCourseResources().remove(studentCourseResource);
		}
		studentCourseResource.setCourse(this);
		studentCourseResources.add(studentCourseResource);
	}
	
	public void removeStudentCourseResource(StudentCourseResource studentCourseResource) {
		studentCourseResource.setCourse(null);
		this.studentCourseResources.remove(studentCourseResource);
	}

	@IndexedEmbedded
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<GradeCourseResource> getGradeCourseResources() {
		return gradeCourseResources;
	}

	public void setGradeCourseResources(List<GradeCourseResource> gradeCourseResources) {
		this.gradeCourseResources = gradeCourseResources;
	}

	public void addGradeCourseResource(GradeCourseResource gradeCourseResource) {
		if (gradeCourseResource.getCourse() != null) {
			gradeCourseResource.getCourse().getGradeCourseResources().remove(gradeCourseResource);
		}
		gradeCourseResource.setCourse(this);
		gradeCourseResources.add(gradeCourseResource);
	}
	
	public void removeGradeCourseResource(GradeCourseResource gradeCourseResource) {
		gradeCourseResource.setCourse(null);
		this.gradeCourseResources.remove(gradeCourseResource);
	}
	
	@IndexedEmbedded
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<OtherCost> getOtherCosts() {
		return otherCosts;
	}

	public void setOtherCosts(List<OtherCost> otherCosts) {
		this.otherCosts = otherCosts;
	}
	
	public void addOtherCost(OtherCost otherCost) {
		if (otherCost.getCourse() != null) {
			otherCost.getCourse().getOtherCosts().remove(otherCost);
		}
		otherCost.setCourse(this);
		otherCosts.add(otherCost);
	}
	
	public void removeOtherCost(OtherCost otherCost) {
		otherCost.setCourse(null);
		this.otherCosts.remove(otherCost);
	}

	@Column(name="ENROLMENT_TIME_END")
	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getEnrolmentTimeEnd() {
		return enrolmentTimeEnd;
	}

	public void setEnrolmentTimeEnd(Date enrolmentTimeEnd) {
		this.enrolmentTimeEnd = enrolmentTimeEnd;
	}

	@Column(name="COURSE_FEE")
	public BigDecimal getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(BigDecimal courseFee) {
		this.courseFee = courseFee;
	}

	@Column(name="COURSE_FEE_CURRENCY")
	public Currency getCourseFeeCurrency() {
		return courseFeeCurrency;
	}

	public void setCourseFeeCurrency(Currency courseFeeCurrency) {
		this.courseFeeCurrency = courseFeeCurrency;
	}

	@Field
	@Override
	@Column(name="ARCHIVED", nullable=false)
	public Boolean getArchived() {
		return archived;
	}

	@Override
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

}
