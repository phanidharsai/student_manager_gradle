package com.sbjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbjpa.entity.student;

@Repository
public interface studentDaoInterface extends JpaRepository<student, String>{

}
