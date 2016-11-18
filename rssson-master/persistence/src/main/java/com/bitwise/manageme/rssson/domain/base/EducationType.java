package com.bitwise.manageme.rssson.domain.base;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Indexed
@Table(name="WEB_RSSSON_EDUCATION_TYPES")
@NamedQueries({
	@NamedQuery(name="EducationType.findById", query="select distinct e from EducationType e where e.id=:id"),
	@NamedQuery(name="EducationType.findByIdAndName", query="select distinct e from EducationType e where e.id=:id and e.name=:name"),
	@NamedQuery(name="EducationType.findAll", query="select e from EducationType e")
})
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
public class EducationType implements Serializable, ArchivableEntity {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String code;
	
	private Boolean archived = Boolean.FALSE;

	@Id
	@Column(name="EDUCATION_TYPE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Field
	@NotEmpty
	@Column(name="CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
