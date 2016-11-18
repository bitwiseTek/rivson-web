package com.bitwise.manageme.rssson.domain.security;
/**
 *  
 * @author Sika Kay
 * @date 14/06/16
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="WEB_RSSSON_ROLES",  uniqueConstraints = @UniqueConstraint(columnNames = {
"roles" }))
@NamedQueries({
	@NamedQuery(name="Role.findById", query="select distinct r from Role r where r.id=:id"),
	@NamedQuery(name="Role.findAll", query="SELECT r from Role r")
})
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Role() {
		
	}
	
	public Role(String roleType) {
		this.roleType = roleType;
	}
	
	private Long id;
	
	private String roleType;

	@Id
	@Column(name="ROLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name="ROLES")
	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((roleType == null) ? 0 : roleType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Role))
			return false;
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (roleType == null) {
			if (other.roleType != null)
				return false;
		} else if (!roleType.equals(other.roleType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleType=" + roleType + "]";
	}
}