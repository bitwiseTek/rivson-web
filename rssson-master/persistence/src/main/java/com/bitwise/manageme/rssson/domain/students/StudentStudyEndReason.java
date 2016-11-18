package com.bitwise.manageme.rssson.domain.students;
/**
 *  
 * @author Sika Kay
 * @date 15/06/16
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.search.annotations.DocumentId;

@Entity
@Table(name="WEB_RSSSON_STUDENT_STUDY_END_REASONS")
@NamedQueries({
	@NamedQuery(name="StudentStudyEndReason.findById", query="select distinct s from StudentStudyEndReason s where s.id=:id"),
	@NamedQuery(name="StudentStudyEndReason.findAll", query="select s from StudentStudyEndReason s")
})
public class StudentStudyEndReason implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private StudentStudyEndReason parentReason;
	
	private List<StudentStudyEndReason> childEndReasons = new ArrayList<StudentStudyEndReason>();

	@Id
	@DocumentId
	@Column(name="STUDENT_STUDY_END_REASON_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	public StudentStudyEndReason getParentReason() {
		return parentReason;
	}

	public void setParentReason(StudentStudyEndReason parentReason) {
		this.parentReason = parentReason;
	}

	@OneToMany
	public List<StudentStudyEndReason> getChildEndReasons() {
		return childEndReasons;
	}

	public void setChildEndReasons(List<StudentStudyEndReason> childEndReasons) {
		this.childEndReasons = childEndReasons;
	}
	
	@Transient
	public void addChildEndReason(StudentStudyEndReason child) {
		if (!this.childEndReasons.contains(child)) {
			child.setParentReason(this);
			childEndReasons.add(child);
		} else {
			throw new PersistenceException("childEndReason is already in this StudentStudyEndReason");
		}
	}
	
	@Transient
	public void removeChildEndReason(StudentStudyEndReason child) {
		if (this.childEndReasons.contains(child)) {
			child.setParentReason(null);
			childEndReasons.remove(child);
		} else {
			throw new PersistenceException("childEndReason is not in this StudentStudyEndReason");
		}
	}

}
