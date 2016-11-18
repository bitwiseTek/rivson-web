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
@Table(name="WEB_RSSSON_TRACKED_ENTITY_PROPERTIES")
@NamedQueries({
	@NamedQuery(name="TrackedEntityProperty.findById", query="select distinct t from TrackedEntityProperty t where t.id=:id"),
	@NamedQuery(name="TrackedEntityProperty.findByEntityAndProperty", query="select distinct t from TrackedEntityProperty t where t.entity=:entity and t.property=:property"),
	@NamedQuery(name="TrackedEntityProperty.findAll", query="select t from TrackedEntityProperty t")
})
public class TrackedEntityProperty implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String entity;
	
	private String property;

	@Id
	@Column(name="TRACKED_ENTITY_PROPERTY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="ENTITY", nullable=false)
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	@Column(name="PROPERTY", nullable=false)
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
