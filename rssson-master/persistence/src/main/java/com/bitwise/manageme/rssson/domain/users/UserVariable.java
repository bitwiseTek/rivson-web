package com.bitwise.manageme.rssson.domain.users;
/**
 *  
 * @author Sika Kay
 * @date 17/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="WEB_RSSSON_USER_VARIABLES")
@NamedQueries({
	@NamedQuery(name="UserVariable.findById", query="select distinct u from UserVariable u where u.id=:id"),
	@NamedQuery(name="UserVariable.findAll", query="select u from UserVariable u")
})
public class UserVariable implements Serializable {

	public UserVariable() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private User user;
	
	private UserVariableKey key;
	
	private String value;

	@Id
	@Column(name="USER_VARIABLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name="USER_VARIABLE_KEY_ID")
	public UserVariableKey getKey() {
		return key;
	}

	public void setKey(UserVariableKey key) {
		this.key = key;
	}

	@Column(name="VALUE", nullable=false)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


}
