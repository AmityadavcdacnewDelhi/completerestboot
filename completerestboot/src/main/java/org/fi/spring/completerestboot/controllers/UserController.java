package org.fi.spring.completerestboot.controllers;

import java.util.List;

import org.fi.spring.completerestboot.dto.UserDTO;
import org.fi.spring.completerestboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("all/{pageNo}/{pageSize}")
	public List<UserDTO> getAllUsers(@PathVariable("pageNo")int pageNo,@PathVariable("pageSize")int pageSize,
			@RequestParam("property") String property,@RequestParam("ascending") boolean ascending)
	{
		return userService.getAllUsers(pageNo, pageSize, property, ascending);
	}
	
	@GetMapping("byEmail")
	public List<UserDTO> getUserByEmail(@RequestParam("email") String email)
	{
		return userService.getUserByEmail(email);
	}
  
	@GetMapping("user")
	public UserDTO getUser(@RequestParam("name") String name)
	{
		return userService.getUser(name);
	}
	
	@GetMapping("allByDescending")
	public List<UserDTO> getAllByDescending()
	{
		return userService.getAllByDescending();
	}
	
	@PostMapping("authenticate")
	public UserDTO authenticateUser(@RequestParam("userName")String userName,@RequestParam("password")String password)
	{
		return userService.authenticateUser(userName, password);
	}
	
	

	

}
