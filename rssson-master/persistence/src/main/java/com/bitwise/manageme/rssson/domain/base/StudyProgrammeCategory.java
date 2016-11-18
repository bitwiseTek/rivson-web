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
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "WEB_RSSSON_STUDY_PROGRAMME_CATEGORIES", uniqueConstraints = @UniqueConstraint(columnNames = {
		"name" }))
@NamedQueries({
		@NamedQuery(name = "StudyProgrammeCategory.findById", query = "select distinct s from StudyProgrammeCategory s where s.id=:id"),
		@NamedQuery(name = "StudyProgrammeCategory.findByName", query = "select distinct s from StudyProgrammeCategory s where s.name=:name"),
		@NamedQuery(name = "StudyProgrammeCategory.findAll", query = "select s from StudyProgrammeCategory s") })
public class StudyProgrammeCategory implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private Boolean archived = Boolean.FALSE;

	private EducationType educationType;

	@Id
	@Column(name = "STUDY_PROGRAMME_CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name="EDUCATION_TYPE_ID")
	public EducationType getEducationType() {
		return educationType;
	}

	public void setEducationType(EducationType educationType) {
		this.educationType = educationType;
	}

	@Override
	@Column(name = "ARCHIVED", nullable = false)
	public Boolean getArchived() {
		return archived;
	}

	@Override
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
}
