package org.fi.spring.completerestboot.services;

import java.util.List;

import org.fi.spring.completerestboot.dto.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {

	// first method get by pages
	public List<UserDTO> getAllUsers(@PathVariable("pageNo")int pageNo,@PathVariable("pageSize")int pageSize,
			@RequestParam("property") String property,@RequestParam("ascending") boolean ascending);
	// get by email
	
	public List<UserDTO> getUserByEmail(@RequestParam("email") String email);
	
	//get by name
	public UserDTO getUser(@RequestParam("name") String name);
	
	//get all by derscending order
	public List<UserDTO> getAllByDescending();
	
	//post authenticate
	public UserDTO authenticateUser(@RequestParam("userName")String userName,@RequestParam("password")String password);
}
