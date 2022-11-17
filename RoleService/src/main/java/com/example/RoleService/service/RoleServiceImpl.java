package com.example.RoleService.service;

import com.example.RoleService.entity.Role;
import com.example.RoleService.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository RoleRepository;

	@Override
	@Transactional
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return RoleRepository.save(role);
	}

	@Override
	public String deleteRole(int roleId) {
		// TODO Auto-generated method stub
		RoleRepository.deleteById(roleId);
		return "xoa thanh cong id" + roleId;
	}

	@Override
	public Role updateRole(Role role) {
		Role Role2 = RoleRepository.saveAndFlush(role);
		return Role2;
	}

	@Override
	public Role getRoleById(int id) {
		Role Role = RoleRepository.findById(id).get();
		return Role;
	}

	@Override
	public List<Role> getListRole() {
		List<Role> dsRole = RoleRepository.findAll();
		return dsRole;
	}
}
