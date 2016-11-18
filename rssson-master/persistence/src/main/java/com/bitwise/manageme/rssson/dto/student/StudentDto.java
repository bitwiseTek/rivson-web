package com.bitwise.manageme.rssson.dto.student;
/**
 *  
 * @author Sika Kay
 * @date 10/09/16
 *
 */
import java.io.Serializable;

import com.bitwise.manageme.rssson.domain.base.LGA;
import com.bitwise.manageme.rssson.domain.students.Student;

public class StudentDto extends Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public StudentDto() {
		
	}
	
	public StudentDto(Long id, String studentId, String nationality, String stateOfOrigin, LGA lga) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.nationality = nationality;
		this.stateOfOrigin = stateOfOrigin;
		this.lga = lga;
	}
	
	private Long id;
	
	private String studentId;
	
	private String nationality;
	
	private String stateOfOrigin;
	
	private LGA lga;
	
	private Boolean lodging;
	
	private String additionalInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getStateOfOrigin() {
		return stateOfOrigin;
	}

	public void setStateOfOrigin(String stateOfOrigin) {
		this.stateOfOrigin = stateOfOrigin;
	}

	public LGA getLga() {
		return lga;
	}

	public void setLga(LGA lga) {
		this.lga = lga;
	}

	public Boolean getLodging() {
		return lodging;
	}

	public void setLodging(Boolean lodging) {
		this.lodging = lodging;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}
