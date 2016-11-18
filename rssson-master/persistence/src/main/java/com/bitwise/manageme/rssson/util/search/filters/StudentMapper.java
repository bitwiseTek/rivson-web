package com.bitwise.manageme.rssson.util.search.filters;
/**
 *  
 * @author Sika Kay
 * @date 10/02/16
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.bitwise.manageme.rssson.domain.students.Student;
import com.bitwise.manageme.rssson.dto.student.StudentDto;

public class StudentMapper {
	
	public static StudentDto map(Student student) {
		StudentDto dto = new StudentDto();
		dto.setId(student.getId());
		dto.setStudentId(student.getStudentId());
		dto.setNationality(student.getNationality());
		dto.setStateOfOrigin(student.getStateOfOrigin());
		dto.setLga(student.getLga());
		dto.setStudyStartDate(student.getStudyStartDate());
		dto.setStudyEndDate(student.getStudyEndDate());
		dto.setLodging(student.getLodging());
		dto.setAdditionalInfo(student.getAdditionalInfo());
		return dto;
	}

	public static List<StudentDto> map(Page<Student> students) {
		List<StudentDto> dtos = new ArrayList<StudentDto>();
		for (Student student : students) {
			dtos.add(map(student));
		}
		return dtos;
 	}
}
