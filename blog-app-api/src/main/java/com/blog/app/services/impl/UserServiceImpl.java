package com.blog.app.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.entities.User;
import com.blog.app.exceptions.ResourceNotFoundException;
import com.blog.app.payloads.UserDto;
import com.blog.app.repositories.UserRepo;
import com.blog.app.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private  UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User entity=this.dtoToEntity(userDto);
		User save = this.userRepo.save(entity);
		return this.entityToDto(save);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
		User user=this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","Id",id));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser=this.userRepo.save(user);
		UserDto userDto1=this.entityToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Long id) {
		User user=this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "Id", id));
		return this.entityToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=this.userRepo.findAll();
		List<UserDto> list = users.stream().map(user->this.entityToDto(user)).collect(Collectors.toList());
		return list;
	}

	@Override
	public void deleteUser(Long id) {
		User user=this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "Id", id));
		this.userRepo.delete(user);
		
	}

	
	public User dtoToEntity(UserDto userDto) {
//		User user=new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		User user=this.modelMapper.map(userDto,User.class);
		return user;
	}//end dtoToEntity
	
	public UserDto entityToDto(User user) {
//		UserDto dto=new UserDto();
//		dto.setId(user.getId());
//		dto.setName(user.getName());
//		dto.setEmail(user.getEmail());
//		dto.setPassword(user.getPassword());
//		dto.setAbout(user.getAbout());
		UserDto dto=this.modelMapper.map(user,UserDto.class);
		return dto;
	}//end entityToDto 
	
}
