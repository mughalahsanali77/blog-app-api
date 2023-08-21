package com.blog.app.services;

import java.util.List;

import com.blog.app.payloads.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto,Long id);
	UserDto getUserById(Long id);
	List<UserDto> getAllUsers();
	void deleteUser(Long id);
	

}
