package com.example.UserService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.UserService.entity.User;

@Service
public interface UserService {

	public User addUser(User user);

	public String deleteUser(int userId);

	public User updateUser(User user);

	public User getUserById(int id);

	public List<User> getListUser();
}
