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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
@Table(name="WEB_RSSSON_STUDY_PROGRAMMES")
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
@NamedQueries({
	@NamedQuery(name="StudyProgramme.findById", query="select distinct s from StudyProgramme s where s.id=:id"),
	@NamedQuery(name="StudyProgramme.findByName", query="select distinct s from StudyProgramme s where s.name=:name"),
	@NamedQuery(name="StudyProgramme.findByCode", query="select distinct s from StudyProgramme s where s.code=:code"),
	@NamedQuery(name="StudyProgramme.findAll", query="select s from StudyProgramme s")
})
public class StudyProgramme implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String code;
	
	private StudyProgrammeCategory category;
	
	private Boolean archived = Boolean.FALSE;

	@Id
	@DocumentId
	@Column(name="STUDY_PROGRAMME_ID")
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

	@Field
	@Column(name="CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne
	@JoinColumn(name="STUDY_PROGRAMME_CATEGORY_ID")
	public StudyProgrammeCategory getCategory() {
		return category;
	}

	public void setCategory(StudyProgrammeCategory category) {
		this.category = category;
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
