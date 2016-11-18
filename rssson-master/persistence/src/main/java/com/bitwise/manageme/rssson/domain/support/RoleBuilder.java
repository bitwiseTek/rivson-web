package com.bitwise.manageme.rssson.domain.support;

import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.security.Role;

@Component
public class RoleBuilder extends EntityBuilder<Role> {

	@Override
	void initProduct() {
		this.product = new Role();	
	}
	
	public RoleBuilder role(String roleType) {
		this.product.setRoleType(roleType);
		return this;
	}

	@Override
	Role assembleProduct() {
		return this.product;
	}

}
