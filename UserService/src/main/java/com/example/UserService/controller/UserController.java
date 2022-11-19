package com.example.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService.entity.User;
import com.example.UserService.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("")
	public User addUser(@RequestBody User User) {
		userService.addUser(User);
		return User;
	}

	@DeleteMapping("/{UserId}")
	public String deleteUser(@PathVariable int UserId) {
		userService.deleteUser(UserId);
		return "xoá thành công id" + UserId;
	}

	@PostMapping("/update")
	public User updateUser(@RequestBody User User) {
		User User2 = userService.updateUser(User);
		return User2;
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		User User = userService.getUserById(id);
		return User;
	}

	@GetMapping("")
	public List<User> getListUser() {
		List<User> dsUser = userService.getListUser();
		return dsUser;
	}
}
