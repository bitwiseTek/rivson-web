package com.bitwise.manageme.rssson.domain.changelog;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bitwise.manageme.rssson.domain.users.User;

@Entity
@Table(name="WEB_RSSSON_CHANGE_LOG_ENTRIES")
@NamedQueries({
	@NamedQuery(name="ChangeLogEntry.findById", query="select distinct c from ChangeLogEntry c where c.id=:id"),
	@NamedQuery(name="ChangeLogEntry.findAll", query="select c from ChangeLogEntry c")
})
public class ChangeLogEntry implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private ChangeLogEntryType type;
	
	private ChangeLogEntryEntity entity;
	
	private String entityId;
	
	private Date time;
	
	private User user;

	@Id
	@Column(name="CHANGE_LOG_ENTRY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="CHANGE_LOG_ENTRY_TYPE")
	public ChangeLogEntryType getType() {
		return type;
	}

	public void setType(ChangeLogEntryType type) {
		this.type = type;
	}

	@ManyToOne
	@JoinColumn(name="CHANGE_LOG_ENTRY_ENTITY_ID")
	public ChangeLogEntryEntity getEntity() {
		return entity;
	}

	public void setEntity(ChangeLogEntryEntity entity) {
		this.entity = entity;
	}

	@Column(name="ENTITY_ID", nullable=false)
	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	@Column(name="TIME")
	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
