package com.bitwise.manageme.rssson.domain.file;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;
import com.bitwise.manageme.rssson.domain.users.User;

@Entity
@Table(name="WEB_RSSSON_FILES")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name="File.findById", query="select distinct f from File f where f.id=:id"),
	@NamedQuery(name="File.findAll", query="select f from File f")
})
public class File implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String fileName;
	
	private FileType fileType;
	
	private String contentType;
	
	private byte[] data;
	
	private Boolean archived = Boolean.FALSE;
	
	private User creator;
	
	private Date created;
	
	private User lastModifier;
	
	private Date lastModified;

	@Id
	@Column(name="FILE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="FILE_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="NAME")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@ManyToOne
	@JoinColumn(name="FILE_TYPE_ID")
	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	@Column(name="CONTENT_TYPE")
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Lob
	@Column(name="DATA")
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	@Column(name="CREATED_DATE", nullable=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@ManyToOne
	@JoinColumn(name="MODIFIER_ID")
	public User getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(User lastModifier) {
		this.lastModifier = lastModifier;
	}

	@Column(name="MODIFIED_DATE", nullable=false)
	@Temporal(value=TemporalType.TIMESTAMP)
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
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
