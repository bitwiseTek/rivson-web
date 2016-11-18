package com.bitwise.manageme.rssson.domain.accesslog;
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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="WEB_RSSSON_ACCESS_LOG_ENTRY_PATHS")
@NamedQueries({
	@NamedQuery(name="AccessLogEntryPath.findById", query="select distinct a from AccessLogEntryPath a where a.id=:id"),
	@NamedQuery(name="AccessLogEntryPath.findAll", query="select a from AccessLogEntryPath a")
})
public class AccessLogEntryPath implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String path;
	
	private Boolean active;

	@Id
	@Column(name="PATH_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Lob
	@Column(name="PATH", nullable=false)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name="ACTIVE", nullable=false)
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
