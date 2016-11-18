package com.bitwise.manageme.rssson.domain.students;
/**
 *  
 * @author Sika Kay
 * @date 15/11/16
 *
 */
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.bitwise.manageme.rssson.domain.help.StudentManual;
import com.bitwise.manageme.rssson.util.forms.StudentPDFAttachment;

@Entity
@Table(name="WEB_RSSSON_STUDENT_PDFs")
@NamedQueries({
	@NamedQuery(name="StudentManualPDF.findById", query="select distinct s from StudentManualPDF s where s.id=:id"),
	@NamedQuery(name="StudentManualPDF.findAll", query="select s from StudentManualPDF s")
})
public class StudentManualPDF extends StudentPDFAttachment {

	private static final long serialVersionUID = 1L;
	
	private StudentManual studentManual;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STUDENT_MANUAL_ID")
	public StudentManual getStudentManual() {
		return studentManual;
	}

	public void setStudentManual(StudentManual studentManual) {
		this.studentManual = studentManual;
	}
}
