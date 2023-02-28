package com.example.demo.controllers.feigns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AsgardeoUserResponse {

	private int totalResults;
	private int startIndex;
	private int itemsPerPage;

	
	private Schema schemas;
	
	private ArrayList<Resource> Resources;
}
