package com.bitwise.manageme.rssson.domain.base;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
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

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name="WEB_RSSSON_COURSE_BASE_VARIABLE_KEYS")
@NamedQueries({
	@NamedQuery(name="CourseBaseVariableKey.findById", query="select distinct c from CourseBaseVariableKey c where c.id=:id"),
	@NamedQuery(name="CourseBaseVariableKey.findAll", query="select c from CourseBaseVariableKey c")
})
public class CourseBaseVariableKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Boolean userEditable = Boolean.FALSE;
	
	private String variableKey;
	
	private String variableName;
	
	private VariableType variableType;

	@Id
	@Column(name="COURSE_BASE_VARIABLE_KEY_ID")
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

}
