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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;

@Entity
@Table(name="WEB_RSSSON_STUDENT_GROUP_STUDENTS")
@NamedQueries({
	@NamedQuery(name="StudentGroupStudent.findById", query="select distinct s from StudentGroupStudent s where s.id=:id"),
	@NamedQuery(name="StudentGroupStudent.findAll", query="select s from StudentGroupStudent s")
})
public class StudentGroupStudent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private StudentGroup studentGroup;
	
	private Student student;

	@Id
	@DocumentId
	@Column(name="STUDENT_GROUP_STUDENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name="STUDENT_GROUP_ID")
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}

	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}

	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
