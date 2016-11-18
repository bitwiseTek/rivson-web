package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import java.util.Date;

import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntry;
import com.bitwise.manageme.rssson.domain.students.StudentContactLogEntryType;

@Component
public class StudentContactLogEntryBuilder extends EntityBuilder<StudentContactLogEntry> {

	@Override
	void initProduct() {
		this.product = new StudentContactLogEntry();
	}
	
	public StudentContactLogEntryBuilder student(Student student) {
		this.product.setStudent(student);
		return this;
	}
	
	public StudentContactLogEntryBuilder studentContactLogEntryType(StudentContactLogEntryType logEntryType) {
		this.product.setType(logEntryType);
		return this;
	}
	
	public StudentContactLogEntryBuilder logEntryDetails(String creatorName, Date entryDate, String text, Boolean archived) {
		this.product.setCreatorName(creatorName);
		this.product.setEntryDate(entryDate);
		this.product.setText(text);
		this.product.setArchived(archived);
		return this;
	}

	@Override
	StudentContactLogEntry assembleProduct() {
		return this.product;
	}

}
