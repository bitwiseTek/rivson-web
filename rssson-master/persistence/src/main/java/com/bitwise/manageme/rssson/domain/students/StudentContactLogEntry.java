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

import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory;

@Entity
@Table(name="WEB_RSSSON_STUDENT_CONTACT_LOG_ENTRIES")
@FullTextFilterDefs(
	@FullTextFilterDef(
		name="ArchivedContactLogEntry", 
		impl=ArchivedEntityFilterFactory.class
	)
)
@NamedQueries({
	@NamedQuery(name="StudentContactLogEntry.findById", query="select distinct s from StudentContactLogEntry s where s.id=:id"),
	@NamedQuery(name="StudentContactLogEntry.findAll", query="select s from StudentContactLogEntry s")
})
public class StudentContactLogEntry implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Student student;
	
	private String text;
	
	private String creatorName;
	
	private StudentContactLogEntryType type;
	
	private Date entryDate;
	
	private Boolean archived = Boolean.FALSE;
	
	@Id
	@Column(name="STUDENT_CONTACT_LOG_ENTRY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	@Column(name="ENTRY_DATE")
	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
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
