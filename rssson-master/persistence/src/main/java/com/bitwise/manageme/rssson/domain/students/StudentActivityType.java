package com.bitwise.manageme.rssson.domain.students;
/**
 *  
 * @author Sika Kay
 * @date 15/06/16
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

import org.hibernate.search.annotations.DocumentId;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;

@Entity
@Table(name="WEB_RSSSON_STUDENT_ACTIVITY_TYPES")
@NamedQueries({
	@NamedQuery(name="StudentActivityType.findById", query="select distinct s from StudentActivityType s where s.id=:id"),
	@NamedQuery(name="StudentActivityType.findAll", query="select s from StudentActivityType s")
})
public class StudentActivityType implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private Boolean archived = Boolean.FALSE;
	
	@Id
	@DocumentId
	@Column(name="STUDENT_ACTIVITY_TYPE_ID")
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
