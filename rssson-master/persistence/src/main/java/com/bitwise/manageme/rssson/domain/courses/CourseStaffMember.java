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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.domain.users.StaffMember;

@Entity
@Table(name="WEB_RSSSON_COURSE_STAFF_MEMBERS")
@NamedQueries({
	@NamedQuery(name="CourseStaffMember.findById", query="select distinct c from CourseStaffMember c where c.id=:id"),
	@NamedQuery(name="CourseStaffMember.findAll", query="select c from CourseStaffMember c")
})
public class CourseStaffMember implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private CourseUser courseUser;
	
	private StaffMember staffMember;
	
	@Id
	@Column(name="COURSE_STAFF_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name="COURSE_USER_ID")
	public CourseUser getCourseUser() {
		return courseUser;
	}

	public void setCourseUser(CourseUser courseUser) {
		this.courseUser = courseUser;
	}


	@ManyToOne
	@JoinColumn(name="STAFF_MEMBER_ID")
	public StaffMember getStaffMember() {
		return staffMember;
	}

	public void setStaffMember(StaffMember staffMember) {
		this.staffMember = staffMember;
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
		if (!(obj instanceof CourseStaffMember))
			return false;
		CourseStaffMember other = (CourseStaffMember) obj;
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
