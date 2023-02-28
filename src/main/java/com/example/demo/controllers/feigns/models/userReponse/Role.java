package com.example.demo.controllers.feigns.models.userReponse;

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
public class Role {

	LinkedHashMap<String,ArrayList<RoleDetail>> roleDetail;
	/*
	 * "":[{"type":"default","value":"Internal/everyone"}]
	 */
}
