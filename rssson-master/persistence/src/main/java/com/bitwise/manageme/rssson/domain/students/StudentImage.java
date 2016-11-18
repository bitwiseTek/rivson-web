package com.bitwise.manageme.rssson.domain.students;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.util.forms.StudentImageAttachment;

@Entity
@Table(name="WEB_RSSSON_STUDENT_IMAGES")
@NamedQueries({
	@NamedQuery(name="StudentImage.findById", query="select distinct s from StudentImage s where s.id=:id"),
	@NamedQuery(name="StudentImage.findAll", query="select s from StudentImage s")
})
public class StudentImage extends StudentImageAttachment {
	
	private static final long serialVersionUID = 1L;
	
	private Student student;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STUDENT_ID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
