package com.cal.demo.controller;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cal.demo.model.Input;

@RestController
public class CalculatorController {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome";
	}
	
	@PostMapping("/{ops}")
	public int cal(@RequestParam(value="ops") String ops, @RequestHeader Map<String, Integer> headers) {
		int a,b;
		Boolean f=false;
		headers.forEach((key, value)->{
			if(f) {
				b=value;
			}
			else {
				f=true;
				a=value;
			}
		});
		if(ops == "addition") {
			return a+b;
		}
		else if(ops == "subtraction") {
			return a - b;
		}
		else if(ops == "multiplication") {
			return a * b;
		}
		else if(ops == "division") {
			if(b==0) {
				return -1;
			}
			else {
				return a / b;
			}
		}
		else {
			return -1;
		}
	}
}
