package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.io.Serializable;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;

@Entity
@Table(name="WEB_RSSSON_COMPONENT_BASE")
@NamedQueries({
	@NamedQuery(name="ComponentBase.findById", query="select distinct c from ComponentBase c where c.id=:id"),
	@NamedQuery(name="ComponentBase.findAll", query="select c from ComponentBase c")
})
public class ComponentBase implements Serializable, ArchivableEntity {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private EducationalLength length = new EducationalLength();
	
	private Boolean archived = Boolean.FALSE;

	@Id
	@Column(name="COMPONENT_BASE_ID")
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

	@JoinColumn(name="EDUCATIONAL_LENGTH_ID")
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	public EducationalLength getLength() {
		return length;
	}

	public void setLength(EducationalLength length) {
		this.length = length;
	}

	@Field
	@Override
	@Column(name="ARCHIVED")
	public Boolean getArchived() {
		return archived;
	}

	@Override
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

}
