package com.example.demo.controllers.feigns;

import com.example.demo.controllers.feigns.models.AsgardeoResponse;
import com.example.demo.controllers.feigns.models.userReponse.AsgardeoUserResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "asgardeo", url = "https://api.asgardeo.io/t/althrh")
public interface AsgardeoFeignClient {
	
	@PostMapping("/oauth2/token")
	public AsgardeoResponse getTokenFromCode(@RequestParam String grant_type, @RequestParam String client_id,
											 @RequestParam String code, @RequestParam String redirect_uri);

	@GetMapping("scim2/Users")
	public AsgardeoUserResponse getUsers(@RequestHeader String token);

	@GetMapping("scim2/Users/search")
	public AsgardeoUserResponse getid(@RequestHeader(value = "Authorization", required = true) String token, @RequestBody int  id);
	
}


//https://api.asgardeo.io/t/altrh/oauth2/token?grant_type=client_credentials&client_id=U5abWEqOf_LxrJ5swKSiyJH7jMQa&code=XXXXX&redirect_uri=http://localhost:3001/redirecturl
