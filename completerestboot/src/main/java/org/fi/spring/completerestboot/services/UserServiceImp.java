package org.fi.spring.completerestboot.services;

import java.util.ArrayList;
import java.util.List;

import org.fi.spring.completerestboot.dto.UserDTO;
import org.fi.spring.completerestboot.entity.UserEntity;
import org.fi.spring.completerestboot.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImp implements UserService {
    @Autowired
	UserRepository repositoryUser;
	@Override
	public List<UserDTO> getAllUsers(int pageNo, int pageSize, String property, boolean ascending) {
Sort sorting = null;
		
		if(ascending)
			sorting = Sort.by(property).ascending();
		else
			sorting = Sort.by(property).descending();

		Pageable page = PageRequest.of(pageNo, pageSize,sorting);
		List<UserEntity> dataList = repositoryUser.findAll(page).toList();
		
		ArrayList<UserDTO> list = new ArrayList<>();
		
		for(UserEntity user : dataList)
		{
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(user, dto);
			list.add(dto);			
		}
		
		return list;
	}

	@Override
	public List<UserDTO> getUserByEmail(String email) {
		List<UserEntity> dataList = repositoryUser.findAll();
		ArrayList<UserDTO> list = new ArrayList<>();
		for(UserEntity user : dataList)
		{
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(user, dto);
			list.add(dto);			
		}
		
		return list;
	}

	@Override
	public UserDTO getUser(String name) {

		UserEntity user = repositoryUser.findByName(name);
		System.out.println(name);
		System.out.println(user);
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(user, dto);
		
		return dto;
	}

	@Override
	public List<UserDTO> getAllByDescending() {
		List<UserEntity> dataList = repositoryUser.getAllRecordsByDescending();
		ArrayList<UserDTO> list = new ArrayList<>();
		for(UserEntity user : dataList)
		{
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(user, dto);
			list.add(dto);			
		}
		
		return list;
	}

	@Override
	public UserDTO authenticateUser(String userName, String password) {

		UserEntity user = repositoryUser.authenticateUser(userName, password);
		UserDTO dto = new UserDTO();
		BeanUtils.copyProperties(user, dto);
		dto.setPassword("************");
		return dto;
	}

}
