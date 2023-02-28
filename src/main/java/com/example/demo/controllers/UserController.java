package com.example.demo.controllers;

import com.example.demo.controllers.dto.UserDto;
import com.example.demo.controllers.feigns.AsgardeoFeignClient;
import com.example.demo.controllers.feigns.AsgardeoUserResponse;
import com.example.demo.services.UserService;
import com.example.demo.services.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
//@CrossOrigin(origins = {"${app.security.cors.origin}"})
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AsgardeoFeignClient asgardeoFeignClient;
    @GetMapping("")
    public ResponseEntity<Iterable<UserDto>> getAll(){

        Iterable<User> users = userService.getAll();

        Collection<UserDto> usersDto = new ArrayList<>();
        users.forEach(user -> usersDto.add(user.toUserDto()));

        return ResponseEntity.status(200).body(usersDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable int id){

        User user = userService.get(id);
        if(user == null) return ResponseEntity.status(409).body(null);
        UserDto userDto = user.toUserDto();

        return ResponseEntity.status(200).body(userDto);
    }
    @PostMapping("")
    public ResponseEntity<UserDto> create(@RequestBody UserDto requestDto){
        User user = userService.create(requestDto.toUser());
        if(user == null) return ResponseEntity.status(409).body(null);
        UserDto result = user.toUserDto();
        return ResponseEntity.status(201).body(result);
    }
    @PutMapping("/{id}/validateEmail")
    public boolean validateEmail(@PathVariable int id){
        return userService.validateEmail(id);
    }
    @PutMapping("/{id}/validatePhone/{code}")
    public boolean validatePhone(@PathVariable int id, @PathVariable int code){
        return userService.validatePhone(id, code);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return userService.delete(id);
    }

    @GetMapping("/asgardeo/users/search/{token}")
    public ResponseEntity<AsgardeoUserResponse> getUserByName(@PathVariable String token, @RequestBody int id) {
        return ResponseEntity.status(HttpStatus.OK).body(asgardeoFeignClient.getid(token,id ));
    }

}
