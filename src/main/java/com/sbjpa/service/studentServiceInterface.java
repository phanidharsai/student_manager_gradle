package com.sbjpa.service;

import com.sbjpa.entity.student;

public interface studentServiceInterface {
	
	public student viewprofile(student s);
	public String createprofileService(student s);
	public String deleteProfile(student s1);
	public String updateprofileService(student s1);
	
	
}
