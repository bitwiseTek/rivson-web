package com.bitwise.manageme.rssson.domain.grading;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
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

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;

@Entity
@Table(name="WEB_RSSSON_GRADES")
@NamedQueries({
	@NamedQuery(name="Grade.findById", query="select distinct g from Grade g where g.id=:id"),
	@NamedQuery(name="Grade.findByName", query="select distinct g from Grade g where g.name=:name"),
	@NamedQuery(name="Grade.findAll", query="select g from Grade g")
})
public class Grade implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String description;
	
	private GradingScale gradingScale;
	
	private Boolean passingGrade = Boolean.FALSE;
	
	private Boolean archived = Boolean.FALSE;
	
	private String qualification;
	
	private Double GPA;
	
	@Id
	@Column(name="GRADE_ID")
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

	@ManyToOne
	@JoinColumn(name="GRADING_SCALE_ID")
	public GradingScale getGradingScale() {
		return gradingScale;
	}

	public void setGradingScale(GradingScale gradingScale) {
		this.gradingScale = gradingScale;
	}

	@Column(name="PASSING_GRADE", nullable=false)
	public Boolean getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(Boolean passingGrade) {
		this.passingGrade = passingGrade;
	}

	@Column(name="QUALIFICATION")
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	@Column(name="GPA")
	public Double getGPA() {
		return GPA;
	}

	public void setGPA(Double gPA) {
		GPA = gPA;
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
