package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.HibernateException;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.bitwise.manageme.rssson.domain.users.User;

@Entity
@Table(name="WEB_RSSSON_COURSE_BASES", uniqueConstraints = @UniqueConstraint(columnNames = {
"name" }))
@NamedQueries({
	@NamedQuery(name="CourseBase.findById", query="select distinct c from CourseBase c where c.id=:id"),
	@NamedQuery(name="CourseBase.findByName", query="select distinct c from CourseBase c where c.name=:name"),
	@NamedQuery(name="CourseBase.findByCourseCode", query="select distinct c from CourseBase c where c.courseCode=:courseCode"),
	@NamedQuery(name="CourseBase.findAll", query="select c from CourseBase c")
})
public class CourseBase implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private User creator;
	
	private DateTime created;
	
	private User lastModifier;
	
	private DateTime lastModified;
	
	private String description;
	
	private String courseCode;
	
	private Boolean archived = Boolean.FALSE;
	
	private EducationalLength courseLength;
	
	private EducationalLength courseLengthUnits;
	
	private List<Subject> subjects = new ArrayList<Subject>();
	
	private List<CourseEducationType> courseEducationTypes = new Vector<CourseEducationType>();
	
	private List<CourseBaseVariable> variables = new ArrayList<CourseBaseVariable>();
	
	private Long maxParticipationCount;

	@Id
	@DocumentId
	@Column(name="COURSE_BASE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Field
	@NotEmpty
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Transient
	@Field(analyze=Analyze.NO, store=Store.YES)
	public String getNameSortable() {
		return name;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="CREATED_DATE", updatable=false, nullable=false)
	public DateTime getCreated() {
		return created;
	}

	public void setCreated(DateTime created) {
		this.created = created;
	}
	
	@Transient
	public String getCreatedString() {
		return org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(created);
	}

	@ManyToOne
	@JoinColumn(name="MODIFIER_ID")
	public User getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(User lastModifier) {
		this.lastModifier = lastModifier;
	}

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name="MODIFIED_DATE", nullable=false)
	public DateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(DateTime lastModified) {
		this.lastModified = lastModified;
	}
	
	@Transient
	public String getLastModifiedString() {
		return org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(lastModified);
	}

	@Lob
	@Field
	@Column(name="DESCRIPTION")
	@Basic(fetch=FetchType.LAZY)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="courseBase", orphanRemoval=true)
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Field
	@Column(name="COURSE_CODE", nullable=false, unique=true)
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@JoinColumn(name="EDUCATIONAL_LENGTH_ID")
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	public EducationalLength getCourseLength() {
		return courseLength;
	}

	public void setCourseLength(EducationalLength courseLength) {
		this.courseLength = courseLength;
	}
	
	@JoinColumn(name="EDUCATIONAL_LENGTH_UNITS")
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	public EducationalLength getCourseLengthUnits() {
		return courseLengthUnits;
	}

	public void setCourseLengthUnits(EducationalLength courseLengthUnits) {
		this.courseLengthUnits = courseLengthUnits;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="courseBase", orphanRemoval=true)
	public List<CourseEducationType> getCourseEducationTypes() {
		return courseEducationTypes;
	}

	public void setCourseEducationTypes(List<CourseEducationType> courseEducationTypes) {
		this.courseEducationTypes = courseEducationTypes;
	}
	
	public void addCourseEducationType(CourseEducationType courseEducationType) {
		if (courseEducationType.getCourseBase() != null && courseEducationType.getCourseBase() != this) {
			throw new HibernateException("Course base mismatch");
		}
		courseEducationType.setCourseBase(this);
		this.courseEducationTypes.add(courseEducationType);
	}
	
	public void removeCourseEducationType(CourseEducationType courseEducationType) {
		courseEducationType.setCourseBase(null);
		this.courseEducationTypes.remove(courseEducationType);
	}
	
	public boolean contains(EducationType educationType) {
		return getCourseEducationTypeByEducationTypeId(educationType.getId()) != null;
	}
	
	public CourseEducationType getCourseEducationTypeByEducationTypeId(Long educationTypeId) {
		for (CourseEducationType courseEducationType : courseEducationTypes) {
			if (courseEducationType.getEducationType().getId().equals(educationTypeId)) {
				return courseEducationType;
			}
		}
		return null;
	}

	@JoinColumn(name="COURSE_BASE_VARIABLE_ID")
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<CourseBaseVariable> getVariables() {
		return variables;
	}

	public void setVariables(List<CourseBaseVariable> variables) {
		this.variables = variables;
	}

	@Column(name="MAX_PARTICIPANTS")
	public Long getMaxParticipationCount() {
		return maxParticipationCount;
	}

	public void setMaxParticipationCount(Long maxParticipationCount) {
		this.maxParticipationCount = maxParticipationCount;
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
