package com.bitwise.manageme.rssson.domain.changelog;

import java.io.Serializable;

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

@Entity
@Table(name="WEB_RSSSON_CHANGE_LOG_ENTRY_PROPERTIES")
@NamedQueries({
	@NamedQuery(name="ChangeLogEntryProperty.findById", query="select distinct c from ChangeLogEntryProperty c where c.id=:id"),
	@NamedQuery(name="ChangeLogEntryProperty.findByPropertyAndEntityId", query="select distinct c from ChangeLogEntryProperty c where c.property=:property and c.entry.entityId=:entityId order by c.entry.time desc"),
	@NamedQuery(name="ChangeLogEntryProperty.findAll", query="select c from ChangeLogEntryProperty c")
})
public class ChangeLogEntryProperty implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private ChangeLogEntryEntityProperty property;
	
	private ChangeLogEntry entry;
	
	private String value;

	@Id
	@Column(name="CHANGE_LOG_ENTRY_PROPERTY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="CHANGE_LOG_ENTRY_ENTITY_PROPERTY_ID")
	public ChangeLogEntryEntityProperty getProperty() {
		return property;
	}

	public void setProperty(ChangeLogEntryEntityProperty property) {
		this.property = property;
	}

	@ManyToOne
	@JoinColumn(name="CHANGE_LOG_ENTRY_ID")
	public ChangeLogEntry getEntry() {
		return entry;
	}

	public void setEntry(ChangeLogEntry entry) {
		this.entry = entry;
	}

	@Lob
	@Column(name="VALUE")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
