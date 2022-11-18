package com.example.CallService.controller;


import com.example.CallService.entity.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserAPIController {

    String urlUser = "http://localhost:8083/user";
    String urlRole = "http://localhost:8084/role";

    @GetMapping("/user/{id}")
    public UserRole getNews(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> response = restTemplate.getForEntity(urlUser + "/" + id, User.class);

        ResponseEntity<Role> responseRole = restTemplate
                .getForEntity(urlRole + "/" + response.getBody().getRoleid(), Role.class);

        UserRole userRole = new UserRole(response.getBody().getId(), response.getBody().getUsername(),
                response.getBody().getPassword(), response.getBody().getFullname(),
                response.getBody().getStatus(), responseRole.getBody());


        return userRole;
    }

    @GetMapping("/user")

    public List<UserRole> getAllNew() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UserRole>> responseEntity = restTemplate.exchange(urlUser, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<UserRole>>() {
                });
        List<UserRole> userRoles = responseEntity.getBody();

        ResponseEntity<List<User>> responseUsers = restTemplate.exchange(urlUser, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
                });
        List<User> users = responseUsers.getBody();
        List<UserRole> newArrayList = new ArrayList<UserRole>();
        for (User user : users) {
            Role role = new Role();
            role = restTemplate.getForObject(urlRole + "/" + user.getRoleid(), Role.class);
            UserRole userRole = new UserRole();
            userRole = restTemplate.getForObject(urlUser + "/" + user.getId(), UserRole.class);
            userRole.setRole(role);
            newArrayList.add(userRole);
        }
        return newArrayList;

    }


    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);
        restTemplate.delete(urlUser + "/" + id, params);
        return "Xóa Thành Công";
    }

    @PostMapping("/user")
    public String createNews(@RequestBody User user) {
        RestTemplate restTemplate = new RestTemplate();
        User response = restTemplate.postForObject(urlUser, user, User.class);
        return "thêm thành công";

    }

//	Category

    @GetMapping("/role/{id}")
    public Role getCategory(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> response = restTemplate.getForEntity(urlRole + "/" + id, Role.class);
        return response.getBody();
    }

}
