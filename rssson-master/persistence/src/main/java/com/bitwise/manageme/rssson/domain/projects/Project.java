package com.bitwise.manageme.rssson.domain.projects;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.domain.base.EducationalLength;
import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory;

@Entity
@Indexed
@Table(name="WEB_RSSSON_PROJECTS")
@FullTextFilterDefs(
	@FullTextFilterDef(
		name="ArchivedProject", 
		impl=ArchivedEntityFilterFactory.class
	)
)
@NamedQueries({
	@NamedQuery(name="Project.findById", query="select distinct p from Project p where p.id=:id"),
	@NamedQuery(name="Project.findAll", query="select p from Project p")
})
public class Project implements Serializable, ArchivableEntity {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String description;
	
	private EducationalLength optionalStudiesLength = new EducationalLength();
	
	private User creator;
	
	private Date created;
	
	private User lastModifier;
	
	private Date lastModified;
	
	private Boolean archived = Boolean.FALSE;

	@Id
	@DocumentId
	@Column(name="PROJECT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Field
	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Lob
	@Field
	@Column(name="DESCRIPTION")
	@Basic(fetch=FetchType.LAZY)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@IndexedEmbedded
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	public EducationalLength getOptionalStudiesLength() {
		return optionalStudiesLength;
	}

	public void setOptionalStudiesLength(EducationalLength optionalStudiesLength) {
		this.optionalStudiesLength = optionalStudiesLength;
	}
	
	@Transient
	@Field(analyze=Analyze.NO, store=Store.YES)
	public String getNameSortable() {
		return name;
	}

	@Temporal(value=TemporalType.TIMESTAMP)
	@Field(analyze=Analyze.NO, store=Store.YES)
	@DateBridge(resolution=Resolution.MILLISECOND)
	@Column(name="MODIFIED_DATE_TIME", nullable=false)
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Temporal(value=TemporalType.TIMESTAMP)
	@Field(analyze=Analyze.NO, store=Store.YES)
	@DateBridge(resolution=Resolution.MILLISECOND)
	@Column(name="CREATED_DATE_TIME", nullable=false, updatable=false)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	@IndexedEmbedded(depth=1)
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	@ManyToOne
	@JoinColumn(name="MODIFIER_ID")
	public User getLastModifier() {
		return lastModifier;
	}
	
	public void setLastModifier(User lastModifier) {
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

}
