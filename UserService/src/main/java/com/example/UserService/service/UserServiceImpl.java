package com.example.UserService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserService.entity.User;
import com.example.UserService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository UserRepository;

	@Override
	@Transactional
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return UserRepository.save(user);
	}

	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		UserRepository.deleteById(userId);
		return "xoa thanh cong id" + userId;
	}

	@Override
	public User updateUser(User user) {
		User User2 = UserRepository.saveAndFlush(user);
		return User2;
	}

	@Override
	public User getUserById(int id) {
		User user = UserRepository.findById(id).get();
		return user;
	}

	@Override
	public List<User> getListUser() {
		List<User> dsUser = UserRepository.findAll();
		return dsUser;
	}
}
