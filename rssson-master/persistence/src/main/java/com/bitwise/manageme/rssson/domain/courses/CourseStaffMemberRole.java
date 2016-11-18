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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="WEB_RSSSON_COURSE_STAFF_MEMBER_ROLES")
@NamedQueries({
	@NamedQuery(name="CourseStaffMemberRole.findById", query="select distinct c from CourseStaffMemberRole c where c.id=:id"),
	@NamedQuery(name="CourseStaffMemberRole.findAll", query="select c from CourseStaffMemberRole c")
})
public class CourseStaffMemberRole implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;

	@Id
	@Column(name="COURSE_STAFF_MEMBER_ROLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
