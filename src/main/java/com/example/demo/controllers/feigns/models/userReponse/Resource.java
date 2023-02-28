package com.example.demo.controllers.feigns.models.userReponse;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Resource {

	private Meta meta;
	private Schema schemas;
	private String username;
	private String id;
	private Name name;
	
	private ArrayList<Email> emails;
	
	@JsonProperty("urn:ietf:params:scim:schemas:extension:enterprise:2.0:User")
	private UserParam userParam;
	
	private Role roles;
}
