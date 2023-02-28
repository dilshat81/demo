package com.example.demo.controllers.feigns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Email {

	private LinkedHashMap<String,String> emails;
}
