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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="WEB_RSSSON_CREDIT_VARIABLES")
@NamedQueries({
	@NamedQuery(name="CreditVariable.findById", query="select distinct c from CreditVariable c where c.id=:id"),
	@NamedQuery(name="CreditVariable.findAll", query="select c from CreditVariable c")
})
public class CreditVariable implements Serializable {
	
	public CreditVariable() {
		super();
	}
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Credit credit;
	
	private CreditVariableKey key;
	
	private String value;

	@Id
	@Column(name="CREDIT_VARIABLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="CREDIT_VARIABLE_KEY_ID")
	public CreditVariableKey getKey() {
		return key;
	}

	public void setKey(CreditVariableKey key) {
		this.key = key;
	}

	@ManyToOne
	@JoinColumn(name="CREDIT_ID")
	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	@Lob
	@Column(name="VALUE", nullable=false)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
