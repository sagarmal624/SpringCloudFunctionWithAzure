package com.example.hellofunction.service;

import com.example.hellofunction.domains.User;
import com.example.hellofunction.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setId(1);
        user.setName("Piyush Jain");
        user.setEmail("piyush@gmail.com");
        users.add(user);
    }

    public ResponseDTO save(User user) {
        users.add(user);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setData(user);
        return responseDTO;
    }

    public ResponseDTO update(User user) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (user.getId() != null) {
            users.removeIf(it -> it.getId() == user.getId());
            users.add(user);
            responseDTO.setData(user);
            responseDTO.setStatus(true);
            responseDTO.setMessage("Record Update Successfully ");
        } else {
            responseDTO.setMessage("Record Id is not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    public ResponseDTO get(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (id != null) {
            User user = users.stream().filter(it -> it.getId() == id).findFirst().get();
            responseDTO.setData(user);
            responseDTO.setStatus(true);
        } else {
            responseDTO.setMessage("Record Id is not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    public ResponseDTO delete(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (id != null) {
            users.removeIf(it -> it.getId() == id);
            responseDTO.setMessage("Record is deleted successfully");
            responseDTO.setStatus(true);
        } else {
            responseDTO.setMessage("Record Id is not found");
            responseDTO.setStatus(false);
        }
        return responseDTO;
    }

    public ResponseDTO getAll() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(users);
        return responseDTO;
    }

    public ResponseDTO userProfile(String id) {
        User user = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/" + id, User.class).getBody();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(user);
        return responseDTO;
    }
}
