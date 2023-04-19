package com.gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
	
	public Exam findByName(String name);
	
	public List<Exam> findAll();
	
	public Exam findById(long id);
	
	

}
