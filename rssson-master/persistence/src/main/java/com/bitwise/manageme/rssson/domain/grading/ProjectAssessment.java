package com.bitwise.manageme.rssson.domain.grading;
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
import javax.persistence.Transient;

import com.bitwise.manageme.rssson.domain.projects.StudentProject;
import com.bitwise.manageme.rssson.domain.students.Student;

@Entity
@PrimaryKeyJoinColumn(name="CREDIT_ID")
@Table(name="WEB_RSSSON_PROJECT_ASSESSMENTS")
@NamedQueries({
	@NamedQuery(name="ProjectAssessment.findById", query="select distinct p from ProjectAssessment p where p.id=:id"),
	@NamedQuery(name="ProjectAssessment.findAll", query="select p from ProjectAssessment p")
})
public class ProjectAssessment extends Credit implements Serializable {
	
	public ProjectAssessment() {
		super();
		setCreditType(CreditType.CourseAssessment);
	}
	
	private static final long serialVersionUID = 1L;
	
	private StudentProject studentProject;

	@Transient
	public Student getStudent() {
		return studentProject != null ? studentProject.getStudent() : null;
	}
	@ManyToOne
	@JoinColumn(name="STUDENT_PROJECT_ID")
	public StudentProject getStudentProject() {
		return studentProject;
	}

	public void setStudentProject(StudentProject studentProject) {
		this.studentProject = studentProject;
	}

}
