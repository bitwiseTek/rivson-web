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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.domain.users.User;

@Entity
@Table(name="WEB_RSSSON_COURSE_USERS")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name="CourseUser.findById", query="select distinct c from CourseUser c where c.id=:id"),
	@NamedQuery(name="CourseUser.findAll", query="select c from CourseUser c")
})
public class CourseUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Course course;
	
	private User user;
	
	@Id
	@Column(name="COURSE_USER_ID")
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

	@OneToOne
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
