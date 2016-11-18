package com.bitwise.manageme.rssson.domain.grading;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;

@Entity
@Table(name="WEB_RSSSON_GRADING_SCALES")
@NamedQueries({
	@NamedQuery(name="GradingScale.findById", query="select distinct g from GradingScale g where g.id=:id"),
	@NamedQuery(name="GradingScale.findByName", query="select distinct g from GradingScale g where g.name=:name"),
	@NamedQuery(name="GradingScale.findAll", query="select g from GradingScale g")
})
public class GradingScale implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private Boolean archived = Boolean.FALSE;
	
	private List<Grade> grades = new ArrayList<Grade>();
	
	@Id
	@Column(name="GRADE_SCALE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
	@Transient
	public void addGrade(Grade grade) {
		if (grade.getGradingScale() != null) {
			grade.getGradingScale().removeGrade(grade);
		}
		grade.setGradingScale(this);
		grades.add(grade);
	}
	
	@Transient
	public void removeGrade(Grade grade) {
		grades.remove(grade);
		grade.setGradingScale(null);
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
