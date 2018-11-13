package com.scb.ga.interfaces.facade.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.scb.ga.domain.User;
import com.scb.ga.interfaces.facade.commondobject.ProfileCommand;
import com.scb.ga.interfaces.facade.commondobject.UserCommond;
import com.scb.ga.interfaces.facade.dto.UserDto;
import com.scb.ga.util.BeanUtil;

/**
 * @author David Wang
 *
 */
public class UserAssembler {

	public static User commondToDomain(UserCommond commond) {
		User user = new User();
		BeanUtil.copeProperties(commond, user);
		return user;
	}

	public static User commondToDomain(String uid, UserCommond commond) {
		User user = new User();
		BeanUtil.copeProperties(commond, user);
		user.setId(uid);
		return user;
	}

	public static User profileToDomain(String uid, ProfileCommand commond) {
		User user = new User();
		BeanUtil.copeProperties(commond, user);
		user.setId(uid);
		return user;
	}

	public static UserDto domainToDto(User user) {
		UserDto dto = new UserDto();
		BeanUtil.copeProperties(user, dto);
		return dto;
	}

	public static List<UserDto> domainToDto(List<User> user) {
		if (CollectionUtils.isEmpty(user)) {
			return null;
		}
		List<UserDto> dtos = new ArrayList<>(user.size());
		user.stream().forEach(user1 -> {
			dtos.add(domainToDto(user1));
		});
		return dtos;
	}

}
