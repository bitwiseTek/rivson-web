package com.bitwise.manageme.rssson.domain.changelog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="WEB_RSSSON_CHANGE_LOG_ENTRY_ENTITY_PROPERTIES")
@NamedQueries({
	@NamedQuery(name="ChangeLogEntryEntityProperty.findById", query="select distinct c from ChangeLogEntryEntityProperty c where c.id=:id"),
	@NamedQuery(name="ChangeLogEntryEntityProperty.findByEntityAndName", query="select distinct c from ChangeLogEntryEntityProperty c where c.name=:name and c.entity=:entity"),
	@NamedQuery(name="ChangeLogEntryEntityProperty.findAll", query="select c from ChangeLogEntryEntityProperty c")
})
public class ChangeLogEntryEntityProperty implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private ChangeLogEntryEntity entity;

	@Id
	@Column(name="CHANGE_LOG_ENTRY_ENTITY_PROPERTY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="NAME", unique=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name="CHANGE_LOG_ENTRY_ENTITY_ID")
	public ChangeLogEntryEntity getEntity() {
		return entity;
	}

	public void setEntity(ChangeLogEntryEntity entity) {
		this.entity = entity;
	}
}
