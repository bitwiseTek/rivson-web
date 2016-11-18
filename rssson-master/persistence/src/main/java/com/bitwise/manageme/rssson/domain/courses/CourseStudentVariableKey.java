package com.bitwise.manageme.rssson.domain.courses;
/**
 *  
 * @author Sika Kay
 * @date 11/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;

import com.bitwise.manageme.rssson.domain.base.VariableType;

@Entity
@Table(name="WEB_RSSSON_COURSE_STUDENT_VARIABLE_KEYS")
@NamedQueries({
	@NamedQuery(name="CourseStudentVariableKey.findById", query="select distinct c from CourseStudentVariableKey c where c.id=:id"),
	@NamedQuery(name="CourseStudentVariableKey.findAll", query="select c from CourseStudentVariableKey c")
})
public class CourseStudentVariableKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Boolean userEditable = Boolean.FALSE;
	
	private String variableKey;
	
	private String variableName;
	
	private VariableType variableType;
	
	private Long version;

	@Id
	@Column(name="COURSE_STUDENT_VARIABLE_KEY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="USER_EDITABLE", nullable=false)
	public Boolean getUserEditable() {
		return userEditable;
	}

	public void setUserEditable(Boolean userEditable) {
		this.userEditable = userEditable;
	}

	@Column(name="VARIABLE_KEY", nullable=false)
	public String getVariableKey() {
		return variableKey;
	}

	public void setVariableKey(String variableKey) {
		this.variableKey = variableKey;
	}

	@Column(name="VARIABLE_NAME", nullable=false)
	public String getVariableName() {
		return variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="VARIABLE_TYPE")
	@Field(analyze=Analyze.NO, store=Store.NO)
	public VariableType getVariableType() {
		return variableType;
	}

	public void setVariableType(VariableType variableType) {
		this.variableType = variableType;
	}

	@Version
	@Column(name="VERSION", nullable=false)
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
