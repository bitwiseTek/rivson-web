package com.bitwise.manageme.rssson.util.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bitwise.manageme.rssson.domain.security.Role;
import com.bitwise.manageme.rssson.service.security.RoleService;

@Component
public class RoleToUserConverter implements Converter<Object, Role> {

	@Autowired
	private RoleService roleService;
	
	@Override
	public Role convert(Object element) {
		Long id = Long.parseLong((String)element);
		Role role= roleService.findById(id);
		System.out.println("Role : "+role);
		return role;
	}

}
