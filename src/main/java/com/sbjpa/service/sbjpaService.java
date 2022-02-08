package com.sbjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbjpa.dao.studentDaoInterface;
import com.sbjpa.entity.student;

@Service
public class sbjpaService implements studentServiceInterface {
	@Autowired
	private studentDaoInterface sd;
	@Override
	public student viewprofile(student s) {
		// TODO Auto-generated method stub
		student ss=sd.findById(s.getEmail()).orElse(null);
		return ss;
	}
	@Override
	public String createprofileService(student s) {
		// TODO Auto-generated method stub
		sd.save(s);
		return "profile created";
	}
	@Override
	public String deleteProfile(student s1) {
		// TODO Auto-generated method stub
		sd.deleteById(s1.getEmail());
		return "profiledeleted";
	}
	@Override
	public String updateprofileService(student s) {
		// TODO Auto-generated method stub
		sd.save(s);
		return "profile updated";
	}

}
