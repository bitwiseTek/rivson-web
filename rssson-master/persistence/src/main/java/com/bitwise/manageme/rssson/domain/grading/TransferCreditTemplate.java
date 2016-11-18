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
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="WEB_RSSSON_TRANSFER_CREDIT_TEMPLATES")
@NamedQueries({
	@NamedQuery(name="TransferCreditTemplate.findById", query="select distinct t from TransferCreditTemplate t where t.id=:id"),
	@NamedQuery(name="TransferCreditTemplate.findAll", query="select t from TransferCreditTemplate t")
})
public class TransferCreditTemplate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private List<TransferCreditTemplateCourse> courses = new ArrayList<TransferCreditTemplateCourse>();

	@Id
	@Column(name="TRANSFER_CREDIT_TEMPLATE_ID")
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

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	public List<TransferCreditTemplateCourse> getCourses() {
		return courses;
	}

	public void setCourses(List<TransferCreditTemplateCourse> courses) {
		this.courses = courses;
	}
	
	@Transient
	public void addCourse(TransferCreditTemplateCourse course) {
		if (!courses.contains(course)) {
			if (course.getTransferCreditTemplate() != null) {
				course.getTransferCreditTemplate().removeCourse(course);
			}
			course.setTransferCreditTemplate(this);
			courses.add(course);
		} else {
			throw new PersistenceException("Template already contains this course");
		}
	}
	
	@Transient
	public void removeCourse(TransferCreditTemplateCourse course) {
		if (courses.contains(course)) {
			course.setTransferCreditTemplate(null);
			courses.remove(course);
		} else {
			throw new PersistenceException("Template does not contain this course");
		}
	}

}
