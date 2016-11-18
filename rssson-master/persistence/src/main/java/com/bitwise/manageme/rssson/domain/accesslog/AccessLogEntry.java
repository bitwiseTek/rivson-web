package com.bitwise.manageme.rssson.domain.accesslog;
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

import org.hibernate.validator.constraints.NotEmpty;

import com.bitwise.manageme.rssson.domain.users.User;

@Entity
@Table(name="WEB_RSSSON_ACCESS_LOG_ENTRIES")
@NamedQueries({
	@NamedQuery(name="AccessLogEntry.findById", query="select distinct a from AccessLogEntry a where a.id=:id"),
	@NamedQuery(name="AccessLogEntry.findAll", query="select a from AccessLogEntry a")
})
public class AccessLogEntry implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private User user;
	
	private AccessLogEntryPath path;
	
	private String ip;
	
	private String parameters;
	
	private Date date;

	@Id
	@Column(name="ACCESS_LOG_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name="PATH_ID")
	public AccessLogEntryPath getPath() {
		return path;
	}

	public void setPath(AccessLogEntryPath path) {
		this.path = path;
	}

	@NotEmpty
	@Column(name="IP", nullable=false)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Lob
	@Column(name="PARAMETERS")
	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE", nullable=false, updatable=false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
