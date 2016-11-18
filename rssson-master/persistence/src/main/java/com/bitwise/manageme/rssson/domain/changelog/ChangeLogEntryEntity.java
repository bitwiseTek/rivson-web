package com.bitwise.manageme.rssson.domain.changelog;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
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

@Entity
@Table(name="WEB_RSSSON_CHANGE_LOG_ENTRIES")
@NamedQueries({
	@NamedQuery(name="ChangeLogEntryEntity.findById", query="select distinct c from ChangeLogEntryEntity c where c.id=:id"),
	@NamedQuery(name="ChangeLogEntryEntity.findByName", query="select distinct c from ChangeLogEntryEntity c where c.name=:name"),
	@NamedQuery(name="ChangeLogEntryEntity.findAll", query="select c from ChangeLogEntryEntity c")
})
public class ChangeLogEntryEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;

	@Id
	@Column(name="CHANGE_LOG_ENTRY_ENTITY_ID")
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
}
