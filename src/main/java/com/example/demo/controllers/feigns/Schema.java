package com.example.demo.controllers.feigns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Schema {

	LinkedHashMap<String,ArrayList<String>> schemas;
	//{
	// "":["urn:ietf:params:scim:api:messages:2.0:ListResponse"]
	//}
	//["urn:ietf:params:scim:api:messages:2.0:ListResponse"]
}
