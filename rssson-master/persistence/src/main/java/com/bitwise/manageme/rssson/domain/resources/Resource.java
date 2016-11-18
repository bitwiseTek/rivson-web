package com.bitwise.manageme.rssson.domain.resources;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
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
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.HibernateException;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FullTextFilterDef;
import org.hibernate.search.annotations.FullTextFilterDefs;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;


@Entity
@Indexed
@Table(name="WEB_RSSSON_RESOURCES")
@FullTextFilterDefs(
	@FullTextFilterDef(
		name="ArchivedResource", 
		impl=com.bitwise.manageme.rssson.util.search.filters.ArchivedEntityFilterFactory.class
	)
)
@Inheritance(strategy=InheritanceType.JOINED)
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries({
	@NamedQuery(name="Resource.findById", query="select distinct r from Resource r where r.id=:id"),
	@NamedQuery(name="Resource.findAll", query="select r from Resource r")
})
public class Resource implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private ResourceCategory category;
	
	private Boolean archived = Boolean.FALSE;
	
	@Id
	@DocumentId
	@Column(name="RESOURCE_ID")
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

	@ManyToOne
	@IndexedEmbedded
	@JoinColumn(name="RESOURCE_CATEGORY_ID")
	public ResourceCategory getCategory() {
		return category;
	}

	public void setCategory(ResourceCategory category) {
		this.category = category;
	}

	@Transient
	@Field(analyze=Analyze.NO)
	public ResourceType getResourceType() {
		throw new HibernateException("Unimplplemented resource type");
	}
	

	@Transient
	@Field(analyze=Analyze.NO, store=Store.YES)
	public String getNameSortable() {
		return name;
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
