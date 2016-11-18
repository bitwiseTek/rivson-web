package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
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
import org.hibernate.search.annotations.Indexed;

import com.bitwise.manageme.rssson.domain.base.ArchivableEntity;

@Entity
@Indexed
@Table(name="WEB_RSSSON_COURSE_STATES")
@NamedQueries({
	@NamedQuery(name="CourseState.findById", query="select distinct c from CourseState c where c.id=:id"),
	@NamedQuery(name="CourseState.findAll", query="select c from CourseState c")
})
public class CourseState implements ArchivableEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private Boolean archived = Boolean.FALSE;

	@Id
	@DocumentId
	@Column(name="COURSE_STATE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NAME", nullable=false, unique=true)
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
