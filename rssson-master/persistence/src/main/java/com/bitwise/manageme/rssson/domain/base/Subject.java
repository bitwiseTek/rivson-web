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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;

import com.bitwise.manageme.rssson.domain.base.EducationType;
import com.bitwise.manageme.rssson.domain.base.AcademicSemester;
import com.bitwise.manageme.rssson.domain.base.CourseBase;
import com.bitwise.manageme.rssson.domain.courses.Course;
import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember;
import com.bitwise.manageme.rssson.domain.students.StudentSubject;
import com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory;

@Entity
@Indexed
@Table(name="WEB_RSSSON_SUBJECTS")
@FullTextFilterDefs(
		@FullTextFilterDef(
			name="ArchivedSubject", 
			impl=ArchivedEntityFilterFactory.class
		)
	)
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries({
	@NamedQuery(name="Subject.findById", query="select distinct s from Subject s where s.id=:id"),
	@NamedQuery(name="Subject.findByName", query="select distinct s from Subject s where s.name=:name"),
	@NamedQuery(name="Subject.findByCode", query="select distinct s from Subject s where s.code=:code"),
	@NamedQuery(name="Subject.findAll", query="select s from Subject s")
})
public class Subject implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String code;
	
	private Boolean archived = Boolean.FALSE;
	
	private Integer academicLevel;
	
	private Integer creditUnit;
	
	private Course course;
	
	private CourseStaffMember subjectLecturer;
	
	private CourseBase courseBase;
	
	private EducationType educationType;
	
	private AcademicSemester semester;

	private List<StudentSubject> studentSubjects = new ArrayList<StudentSubject>();

	@Id
	@DocumentId
	@Column(name="SUBJECT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty
	@Column(name="NAME")
	@Field(store=Store.NO)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Field
	@NotEmpty
	@Column(name="CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Field
	@Column(name="ACADEMIC_LEVEL")
	public Integer getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(Integer academicLevel) {
		this.academicLevel = academicLevel;
	}

	@Field
	@Column(name="CREDIT_UNIT")
	public Integer getCreditUnit() {
		return creditUnit;
	}

	public void setCreditUnit(Integer creditUnit) {
		this.creditUnit = creditUnit;
	}

	@ManyToOne
	@JoinColumn(name="EDUCATION_TYPE_ID")
	public EducationType getEducationType() {
		return educationType;
	}

	public void setEducationType(EducationType educationType) {
		this.educationType = educationType;
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
	@JoinColumn(name="COURSE_STAFF_MEMBER_ID")
	public CourseStaffMember getSubjectLecturer() {
		return subjectLecturer;
	}
	
	public void setSemester(AcademicSemester semester) {
		this.semester = semester;
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
	@JoinColumn(name="SEMESTER_ID")
	public AcademicSemester getSemester() {
		return semester;
	}

	public void setSubjectLecturer(CourseStaffMember subjectLecturer) {
		this.subjectLecturer = subjectLecturer;
	}

	@Override
	@Column(name="ARCHIVED", nullable=false)
	public Boolean getArchived() {
		return archived;
	}

	@Override
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	@OneToMany(cascade=CascadeType.ALL, mappedBy="subject", orphanRemoval=true)
	public List<StudentSubject> getStudentSubjects() {
		return studentSubjects;
	}

	public void setStudentSubjects(List<StudentSubject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Subject))
			return false;
		Subject other = (Subject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + "]";
	}
}
