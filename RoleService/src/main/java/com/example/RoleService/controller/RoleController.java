package com.example.RoleService.controller;

import com.example.RoleService.entity.Role;
import com.example.RoleService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("")
    @CachePut(value = "roles", key = "#Role.id")
    public Role addRole(@RequestBody Role Role) {
        roleService.addRole(Role);
        return Role;
    }

    @DeleteMapping("/{RoleId}")
    @CacheEvict(value = "role", key = "#RoleId")
    public String deleteRole(@PathVariable int RoleId) {
        roleService.deleteRole(RoleId);
        return "xoá thành công id" + RoleId;
    }

    @PostMapping("/update")
    public Role updateRole(@RequestBody Role role) {
        Role Role2 = roleService.updateRole(role);
        return Role2;
    }

    @GetMapping("/{id}")
    @Cacheable(value = "role", key = "#id")
    public Role getRoleById(@PathVariable int id) {
        Role Role = roleService.getRoleById(id);
        return Role;
    }

    @GetMapping("")
    public List<Role> getListRole() {
        List<Role> dsRole = roleService.getListRole();
        return dsRole;
    }
}
