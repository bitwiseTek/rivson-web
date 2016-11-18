package com.bitwise.manageme.rssson.domain.students;
/**
 *  
 * @author Sika Kay
 * @date 15/06/16
 *
 */
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
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
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory;

@Entity
@Indexed
@Table(name="WEB_RSSSON_STUDENT_GROUPS")
@FullTextFilterDefs(
	@FullTextFilterDef(
		name="ArchivedStudentGroup", 
		impl=ArchivedEntityFilterFactory.class
	)
)
@NamedQueries({
	@NamedQuery(name="StudentGroup.findById", query="select distinct s from StudentGroup s where s.id=:id"),
	@NamedQuery(name="StudentGroup.findAll", query="select s from StudentGroup s")
})
public class StudentGroup implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private Date beginDate;
	
	private Boolean archived = Boolean.FALSE;
	
	private com.bitwise.manageme.rssson.domain.users.User creator;
	
	private Date created;
	
	private com.bitwise.manageme.rssson.domain.users.User lastModifier;
	
	private Date lastModified;
	
	private Set<StudentGroupUser> users = new HashSet<StudentGroupUser>();
	
	private Set<StudentGroupStudent> students = new HashSet<StudentGroupStudent>();

	@Id
	@DocumentId
	@Column(name="STUDENT_GROUP_ID")
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

	@Transient
	@Field(analyze=Analyze.NO, store=Store.YES)
	public String getNameSortable() {
		return name;
	}
	@Lob
	@Column(name="DESCRIPTION")
	@Basic(fetch=FetchType.LAZY)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Field
	@Column(name="BEGIN_DATE")
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="MODIFIED_DATE_TIME", nullable=false)
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE_TIME", nullable=false, updatable=false)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	public com.bitwise.manageme.rssson.domain.users.User getCreator() {
		return creator;
	}

	public void setCreator(com.bitwise.manageme.rssson.domain.users.User creator) {
		this.creator = creator;
	}

	@ManyToOne
	@JoinColumn(name="MODIFIER_ID")
	public com.bitwise.manageme.rssson.domain.users.User getLastModifier() {
		return lastModifier;
	}
	
	public void setLastModifier(com.bitwise.manageme.rssson.domain.users.User lastModifier) {
		this.lastModifier = lastModifier;
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

	@OneToMany
	@IndexedEmbedded
	public Set<StudentGroupUser> getUsers() {
		return users;
	}

	public void setUsers(Set<StudentGroupUser> users) {
		this.users = users;
	}
	
	@Transient
	public void addUser(StudentGroupUser user) {
		if (users.contains(user)) {
			throw new PersistenceException("StudentGroup.addUser - user already exists in list");
		}
		
		if (user.getStudentGroup() != null) {
			user.getStudentGroup().removeUser(user);
		}
		user.setStudentGroup(this);
		users.add(user);
	}
	
	@Transient
	public void removeUser(StudentGroupUser user) {
		if (!users.contains(user)) {
			throw new PersistenceException("StudentGroup.removeUser - user does not exist in StudentGroup");
		}
		user.setStudentGroup(null);
		users.remove(user);
	}

	@OneToMany
	public Set<StudentGroupStudent> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentGroupStudent> students) {
		this.students = students;
	}
	
	@Transient
	public void addStudent(StudentGroupStudent student) {
		if (students.contains(student)) {
			throw new PersistenceException("StudentGroup.addStudent - user already exists in list");
		}
		
		if (student.getStudentGroup() != null) {
			student.getStudentGroup().removeStudent(student);
		}
		student.setStudentGroup(this);
		students.add(student);
	}
	
	@Transient
	public void removeStudent(StudentGroupStudent student) {
		if (!students.contains(student)) {
			throw new PersistenceException("StudentGroup.removeStudent - user does not exist in StudentGroup");
		}
		student.setStudentGroup(null);
		students.remove(student);
	}
}
