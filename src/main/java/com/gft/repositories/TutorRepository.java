package com.gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long>{
	
	public Tutor findByName(String name);
	
	public List<Tutor> findAll();
	
	public Tutor findById(long id);

}
