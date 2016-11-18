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
@Table(name="WEB_RSSSON_SGC_LOG_ENTRY_COMMENTS")
@NamedQueries({
	@NamedQuery(name="StudentGroupContactLogEntryComment.findById", query="select distinct s from StudentGroupContactLogEntryComment s where s.id=:id"),
	@NamedQuery(name="StudentGroupContactLogEntryComment.findAll", query="select s from StudentGroupContactLogEntryComment s")
})
public class StudentGroupContactLogEntryComment implements Serializable, ArchivableEntity {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String text;
	
	private String creatorName;
	
	private StudentContactLogEntry entry;
	
	private Date commentDate;
	
	private Boolean archived = Boolean.FALSE;

	@Id
	@Column(name="STUDENT_GROUP_CONTACT_LOG_ENTRY_COMMENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	@ManyToOne
	@JoinColumn(name="STUDENT_CONTACT_LOG_ENTRY_ID")
	public StudentContactLogEntry getEntry() {
		return entry;
	}

	public void setEntry(StudentContactLogEntry entry) {
		this.entry = entry;
	}

	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="COMMENT_DATE_TIME")
	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
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
