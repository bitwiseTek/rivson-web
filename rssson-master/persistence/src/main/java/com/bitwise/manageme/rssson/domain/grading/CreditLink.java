package com.bitwise.manageme.rssson.domain.grading;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.users.User;

@Entity
@Table(name="WEB_RSSSON_CREDIT_LINKS")
@NamedQueries({
	@NamedQuery(name="CreditLink.findById", query="select distinct c from CreditLink c where c.id=:id"),
	@NamedQuery(name="CreditLink.findAll", query="select c from CreditLink c")
})
public class CreditLink implements Serializable, ArchivableEntity {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Credit credit;
	
	private Student student;
	
	private Boolean archived = Boolean.FALSE;
	
	private User creator;
	
	private Date created;
	
	@Id
	@Column(name="CREDIT_LINK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="CREDIT_ID")
	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	@Column(name="CREATED_DATE")
	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
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


}
