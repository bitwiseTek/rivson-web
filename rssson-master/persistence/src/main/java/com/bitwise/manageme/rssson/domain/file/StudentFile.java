package com.bitwise.manageme.rssson.domain.file;
/**
 *  
 * @author Sika Kay
 * @date 12/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.domain.students.Student;

@Entity
@PrimaryKeyJoinColumn(name="FILE_ID")
@Table(name="WEB_RSSSON_STUDENT_FILES")
@NamedQueries({
	@NamedQuery(name="StudentFile.findById", query="select distinct s from StudentFile s where s.id=:id"),
	@NamedQuery(name="StudentFile.findAll", query="select s from StudentFile s")
})
public class StudentFile extends File implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Student student;

	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
