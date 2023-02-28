package com.example.demo.controllers.feigns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AsgardeoResponse {

	private String access_token;
	private String scope;
	private String id_token;
	private String token_type;
	private int expires_in;


}
