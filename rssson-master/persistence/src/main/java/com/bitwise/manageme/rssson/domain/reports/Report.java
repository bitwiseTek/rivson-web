package com.bitwise.manageme.rssson.domain.reports;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Indexed;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory;

@Entity
@Indexed
@Table(name="WEB_RSSSON_REPORTS")
@FullTextFilterDefs(
	@FullTextFilterDef(
		name="ArchivedReport", 
		impl=ArchivedEntityFilterFactory.class
	)
)
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries({
	@NamedQuery(name="Report.findById", query="select distinct r from Report r where r.id=:id"),
	@NamedQuery(name="Report.findAll", query="select r from Report r")
})
public class Report implements Serializable, ArchivableEntity {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private ReportCategory category;
	
	private String name;
	
	private String data;
	
	private User creator;
	
	private Date created;
	
	private User lastModifier;
	
	private Date lastModified;
	
	private Boolean archived = Boolean.FALSE;
	
	@Id
	@Column(name="REPORT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="REPORT_CATEGORY_ID")
	public ReportCategory getCategory() {
		return category;
	}

	public void setCategory(ReportCategory category) {
		this.category = category;
	}

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Lob
	@Column(name="DATA", nullable=false)
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
