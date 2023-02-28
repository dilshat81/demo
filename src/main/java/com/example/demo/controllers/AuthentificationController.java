package com.example.demo.controllers;

import com.example.demo.controllers.dto.UserDto;
import com.example.demo.controllers.feigns.AsgardeoFeignClient;
import com.example.demo.controllers.feigns.models.AsgardeoResponse;
import com.example.demo.controllers.feigns.models.userReponse.AsgardeoUserResponse;
import com.example.demo.services.AuthentificationService;
import com.example.demo.services.UserService;
import com.example.demo.services.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class AuthentificationController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthentificationService authentificationService;
    @Autowired
    private AsgardeoFeignClient asgardeoFeignClient;
    @Value("${authentification.clientId}")
    private String clientId;

    private String redirectUri = "http://localhost:8080/";

    @GetMapping("/authentification/connexionurl")
    public String generatedUri(){
        return "https://api.asgardeo.io/t/imeshaorg/oauth2/authorize?scope=openid email profile&redirect_uri=" + redirectUri + "redirecturl&client_id=" + clientId;
    }
    @GetMapping("/redirecturl")
    public ResponseEntity<String> redirectURL(@RequestParam String code, @RequestParam String sessions_state){
        /*http://localhost:8080/redirecturl
        ?code=66debf10-0463-388b-9645-762a551d1d2b
        &session_state=acbe09284a8bd1b3e35b7e1b31a1b589668f739f7716ed5ee907d847cd5d5307.V7FrGjEkIM4YioYbY14F6w*/
        AsgardeoResponse asgardeoResponse = asgardeoFeignClient.getTokenFromCode("authorization_code", clientId, code, redirectUri);
        String result = asgardeoResponse.getAccess_token();
        return ResponseEntity.status(200).body(result);
    }
    @GetMapping("/asgardeo/users/{token}")
    public ResponseEntity<AsgardeoUserResponse> getAllUsers(@PathVariable String token) {
        System.out.println(token);
        return ResponseEntity.status(HttpStatus.OK).body(asgardeoFeignClient.getUsers(token));
    }
    @PostMapping("/register")
    public ResponseEntity<UserDto> create(@RequestBody UserDto requestDto){

        User user = userService.register(requestDto.toUser());

        if(user == null) return ResponseEntity.status(409).body(null);
        UserDto result = user.toUserDto();
        return ResponseEntity.status(201).body(result);
    }
    @GetMapping("/{id}/{csrfToken}")
    public ResponseEntity<UserDto> getUser(@PathVariable int id, @PathVariable String csrfToken){
        User user = userService.findById(id, csrfToken);
        if(user == null) return ResponseEntity.status(409).body(null);
        UserDto result = user.toUserDto();
        return ResponseEntity.status(201).body(result);
    }
}
