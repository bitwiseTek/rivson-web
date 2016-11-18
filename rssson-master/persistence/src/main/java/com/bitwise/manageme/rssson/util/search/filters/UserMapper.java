package com.bitwise.manageme.rssson.util.search.filters;
/**
 *  
 * @author Sika Kay
 * @date 14/02/16
 *
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.bitwise.manageme.rssson.domain.users.User;
import com.bitwise.manageme.rssson.dto.user.UserDto;

public class UserMapper {

	public static UserDto map(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setSystemId(user.getSystemId());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setMiddleName(user.getMiddleName());
		dto.setSex(user.getSex());
		dto.setIsActive(user.getIsActive());
		dto.setUsername(user.getUsername());
		return dto;
	}
	
	public static List<UserDto> map(Page<User> users) {
		List<UserDto> dtos = new ArrayList<UserDto>();
		for (User user : users) {
			dtos.add(map(user));
		}
		return dtos;
	}
}
