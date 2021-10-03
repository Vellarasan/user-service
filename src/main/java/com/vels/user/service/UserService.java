package com.vels.user.service;

import com.vels.user.Vo.Department;
import com.vels.user.Vo.UserResponseTemplateVo;
import com.vels.user.entity.User;
import com.vels.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public UserResponseTemplateVo findUserById(Long id) {
        UserResponseTemplateVo userResponseTemplateVo = new UserResponseTemplateVo();

        User user = userRepository.findById(id).orElse(null);
        Department department = restTemplate.getForObject("http://localhost:1001/departments/" + user.getDepartmentId(), Department.class);

        userResponseTemplateVo.setUser(user);
        userResponseTemplateVo.setDepartment(department);
        return userResponseTemplateVo;
    }
}
