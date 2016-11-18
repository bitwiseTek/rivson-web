package com.bitwise.manageme.rssson.domain.students;
/**
 *  
 * @author Sika Kay
 * @date 29/09/16
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Indexed;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.CourseStudent;
import com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory;

@Entity
@Indexed
@Table(name="WEB_RSSSON_STUDENT_SUBJECTS")
@FullTextFilterDefs (
  @FullTextFilterDef (
     name="ArchivedStudentSubject",
     impl=ArchivedEntityFilterFactory.class
  )
)
@NamedQueries({
	@NamedQuery(name="StudentSubject.findById", query="select distinct s from StudentSubject s where s.id=:id"),
	@NamedQuery(name="StudentSubject.findAllRegisteredOne", query="select s from StudentSubject s where s.subject.semester.id=1 and s.toggleOnOff is true"),
	@NamedQuery(name="StudentSubject.findAllRegisteredTwo", query="select s from StudentSubject s where s.subject.semester.id=2 and s.toggleOnOff is true"),
	@NamedQuery(name="StudentSubject.findAllOne", query="select s from StudentSubject s where s.subject.semester.id=1"),
	@NamedQuery(name="StudentSubject.findAllTwo", query="select s from StudentSubject s where s.subject.semester.id=2"),
	@NamedQuery(name="StudentSubject.findAll", query="select s from StudentSubject s")
})
public class StudentSubject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Boolean toggleOnOff = Boolean.FALSE;
	
	private Subject subject;
	
	private List<CourseStudent> courseStudents = new ArrayList<CourseStudent>();
	
	@Id
	@DocumentId
	@Column(name="STUDENT_SUBJECT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="LINK_STUDENT_SUBJECTS_COURSE_STUDENTS", joinColumns={@JoinColumn(name="STUDENT_SUBJECT_ID")}, inverseJoinColumns={@JoinColumn(name="COURSE_STUDENT_ID")})
	public List<CourseStudent> getCourseStudents() {
		return courseStudents;
	}

	public void setCourseStudents(List<CourseStudent> courseStudents) {
		this.courseStudents = courseStudents;
	}

	@Column(name="SELECTED")
	public Boolean getToggleOnOff() {
		return toggleOnOff;
	}

	public void setToggleOnOff(Boolean toggleOnOff) {
		this.toggleOnOff = toggleOnOff;
	}

	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((toggleOnOff == null) ? 0 : toggleOnOff.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StudentSubject))
			return false;
		StudentSubject other = (StudentSubject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (toggleOnOff == null) {
			if (other.toggleOnOff != null)
				return false;
		} else if (!toggleOnOff.equals(other.toggleOnOff))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentSubject [id=" + id + ", toggleOnOff=" + toggleOnOff + "]";
	}
	
}
