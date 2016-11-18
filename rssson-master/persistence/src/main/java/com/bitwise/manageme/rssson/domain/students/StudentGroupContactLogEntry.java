package com.bitwise.manageme.rssson.domain.students;
/**
 *  
 * @author Sika Kay
 * @date 15/06/16
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Field;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;

@Entity
@Table(name="WEB_RSSSON_STUDENT_GROUP_CONTACT_LOG_ENTRIES")
@NamedQueries({
	@NamedQuery(name="StudentGroupContactLogEntry.findById", query="select distinct s from StudentGroupContactLogEntry s where s.id=:id"),
	@NamedQuery(name="StudentGroupContactLogEntry.findAll", query="select s from StudentGroupContactLogEntry s")
})
public class StudentGroupContactLogEntry implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private StudentGroup studentGroup;
	
	private String text;
	
	private String creatorName;
	
	private StudentContactLogEntryType type;
	
	private Date entryDate;
	
	private Boolean archived = Boolean.FALSE;

	@Id
	@Column(name="STUDENT_GROUP_CONTACT_LOG_ENTRY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="STUDENT_GROUP_ID")
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}

	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}

	@Lob
	@Column(name="TEXT")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name="CREATOR_NAME")
	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="LOG_ENTRY_TYPE")
	public StudentContactLogEntryType getType() {
		return type;
	}

	public void setType(StudentContactLogEntryType type) {
		this.type = type;
	}

	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="ENTRY_DATE_TIME")
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
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
