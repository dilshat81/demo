package com.example.demo.controllers.feigns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Meta {

	private String created;
	private String location;
	private String lastModified;
	private String resourceType;

}
