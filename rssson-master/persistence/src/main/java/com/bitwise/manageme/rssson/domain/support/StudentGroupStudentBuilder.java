package com.bitwise.manageme.rssson.domain.support;
/**
 *  
 * @author Sika Kay
 * @date 16/06/16
 *
 */
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.domain.students.StudentGroup;
import com.bitwise.manageme.rssson.domain.students.StudentGroupStudent;

@Component
public class StudentGroupStudentBuilder extends EntityBuilder<StudentGroupStudent> {

	@Override
	void initProduct() {
		this.product = new StudentGroupStudent();
	}
	
	public StudentGroupStudentBuilder student(Student student) {
		this.product.setStudent(student);
		return this;
	}
	
	public StudentGroupStudentBuilder studentGroup(StudentGroup studentGroup) {
		this.product.setStudentGroup(studentGroup);
		return this;
	}

	@Override
	StudentGroupStudent assembleProduct() {
		return this.product;
	}

}
