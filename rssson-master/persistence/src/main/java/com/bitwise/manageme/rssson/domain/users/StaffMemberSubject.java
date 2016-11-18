package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 27/09/16
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Indexed;

import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.courses.CourseStaffMember;
import com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory;

@Entity
@Indexed
@Table(name="WEB_RSSSON_STAFF_SUBJECTS")
@FullTextFilterDefs (
  @FullTextFilterDef (
     name="ArchivedStaffSubject",
     impl=ArchivedEntityFilterFactory.class
  )
)
@NamedQueries({
	@NamedQuery(name="StaffMemberSubject.findById", query="select distinct s from StaffMemberSubject s where s.id=:id"),
	@NamedQuery(name="StaffMemberSubject.findAll", query="select s from StaffMemberSubject s")
})
public class StaffMemberSubject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Subject subject;
	
	private List<CourseStaffMember> courseStaff = new ArrayList<CourseStaffMember>();
	
	@Id
	@DocumentId
	@Column(name="STAFF_SUBJECT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="LINK_STAFF_SUBJECTS_COURSE_STAFF_MEMBERS", joinColumns={@JoinColumn(name="STAFF_SUBJECT_ID")}, inverseJoinColumns={@JoinColumn(name="COURSE_STAFF_ID")})
	public List<CourseStaffMember> getCourseStaff() {
		return courseStaff;
	}

	public void setCourseStaff(List<CourseStaffMember> courseStaff) {
		this.courseStaff = courseStaff;
	}
	
	@OneToOne
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
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StaffMemberSubject))
			return false;
		StaffMemberSubject other = (StaffMemberSubject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourseStaffMember [id=" + id + "]";
	}
}
