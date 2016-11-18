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

import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory;

@Entity
@Table(name="WEB_RSSSON_STUDENT_CONTACT_LOG_ENTRY_COMMENTS")
@FullTextFilterDefs(
	@FullTextFilterDef(
		name="ArchivedContactLogEntryComment", 
		impl=ArchivedEntityFilterFactory.class
	)
)
@NamedQueries({
	@NamedQuery(name="StudentContactLogEntryComment.findById", query="select distinct s from StudentContactLogEntryComment s where s.id=:id"),
	@NamedQuery(name="StudentContactLogEntryComment.findAll", query="select s from StudentContactLogEntryComment s")
})
public class StudentContactLogEntryComment implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private StudentContactLogEntry entry;
	
	private String text;
	
	private String creatorName;
	
	private Date commentDate;
	
	private Boolean archived = Boolean.FALSE;
	
	@Id
	@Column(name="STUDENT_CONTACT_LOG_ENTRY_COMMENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="STUDENT_CONTACT_LOG_ENTRY_ID")
	public StudentContactLogEntry getEntry() {
		return entry;
	}

	public void setEntry(StudentContactLogEntry entry) {
		this.entry = entry;
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

	@Column(name="COMMENT_DATE")
	@Temporal(value=TemporalType.DATE)
	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
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
