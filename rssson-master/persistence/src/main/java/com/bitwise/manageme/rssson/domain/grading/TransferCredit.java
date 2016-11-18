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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.domain.base.EducationalLength;
import com.bitwise.manageme.rssson.domain.base.Subject;
import com.bitwise.manageme.rssson.domain.students.Student;

@Entity
@PrimaryKeyJoinColumn(name="CREDIT_ID")
@Table(name="WEB_RSSSON_TRANSFER_CREDITS")
@NamedQueries({
	@NamedQuery(name="TransferCredit.findById", query="select distinct t from TransferCredit t where t.id=:id"),
	@NamedQuery(name="TransferCredit.findAll", query="select t from TransferCredit t")
})
public class TransferCredit extends Credit implements Serializable {

	public TransferCredit() {
		super();
		setCreditType(CreditType.TransferCredit);
	}
	
	private static final long serialVersionUID = 1L;
	
	private Student student;
	
	private String courseName;
	
	private Integer courseCode;
	
	private EducationalLength courseLength;
	
	private String optionality;
	
	private Subject subject;

	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name="COURSE_NAME", nullable=false)
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name="COURSE_CODE")
	public Integer getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(Integer courseCode) {
		this.courseCode = courseCode;
	}

	@OneToOne
	@JoinColumn(name="EDUCATIONAL_LENGTH_ID")
	public EducationalLength getCourseLength() {
		return courseLength;
	}

	public void setCourseLength(EducationalLength courseLength) {
		this.courseLength = courseLength;
	}

	@Column(name="COURSE_OPTIONALITY")
	public String getOptionality() {
		return optionality;
	}

	public void setOptionality(String optionality) {
		this.optionality = optionality;
	}

	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
