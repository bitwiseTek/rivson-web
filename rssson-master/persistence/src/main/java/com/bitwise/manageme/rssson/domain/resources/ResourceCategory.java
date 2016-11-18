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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;

@Entity
@Indexed
@Table(name="WEB_RSSSON_RESOURCE_CATEGORIES")
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries({
	@NamedQuery(name="ResourceCategory.findById", query="select distinct r from ResourceCategory r where r.id=:id"),
	@NamedQuery(name="ResourceCategory.findAll", query="select r from ResourceCategory r")
})
public class ResourceCategory implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private Boolean archived = Boolean.FALSE;
	
	@Id
	@DocumentId
	@Column(name="RESOURCE_CATEGORY_ID")
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
