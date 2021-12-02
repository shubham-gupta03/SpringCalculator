package com.cal.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorController {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome";
	}
	
	@PostMapping("/{ops}")
	public int cal(@PathVariable String ops, @RequestHeader int a, @RequestHeader int b) {

		if(ops.equals("addition")) {
			return (a+b);
		}
		else if(ops.equals("subtraction")) {
			return (a-b);
		}
		else if(ops.equals("multiplication")) {
			return (a*b);
		}
		else if(ops.equals("division")) {
			if(b==0) {
				return -1;
			}
			else {
				return (a/b);
			}
		}
		else {
			return -1;
		}
	}
}
