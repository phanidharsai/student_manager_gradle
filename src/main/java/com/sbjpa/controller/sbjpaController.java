package com.sbjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sbjpa.entity.student;
import com.sbjpa.service.studentServiceInterface;

@RestController
public class sbjpaController {
	@Autowired
	private studentServiceInterface ss;
	@GetMapping("viewprofile/{id}")
	public ResponseEntity viewprofile(@RequestHeader(value="Authorization") String authorization,@PathVariable(value="id") String e) {
		student s1 = new student();
		s1.setEmail(e);
		if(validate(authorization)==true) {
			return ResponseEntity.status(HttpStatus.OK).body(ss.viewprofile(s1));
		}
		else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("unauthorized access "+authorization);
		}
		}
	private boolean validate(String authorization) {
		// TODO Auto-generated method stub
		String[] authorize=authorization.split(" ");
		if(authorize[1].equals("token")) {
			return true;
		}
		return false;
	}
	@PostMapping("createprofile")
	public String cp(@RequestBody student s) {
		String sg=ss.createprofileService(s);
		return sg;
	}
	@DeleteMapping("deleteprofile/{id}")
	public String dp(@PathVariable(value="id") String e) {
		student s1= new student();
		s1.setEmail(e);
		String sg=ss.deleteProfile(s1);
		return sg;
	}
	@PutMapping("updateprofile/{id}")
	public String up(@RequestBody student s) {
		//student s1=new student();
		//s1.setEmail(e);
		return ss.updateprofileService(s);
		
	}

}
