package com.example.RoleService.service;

import com.example.RoleService.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

	public Role addRole(Role role);

	public String deleteRole(int roleId);

	public Role updateRole(Role role);

	public Role getRoleById(int id);

	public List<Role> getListRole();
}
