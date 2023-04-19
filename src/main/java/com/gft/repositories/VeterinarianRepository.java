package com.gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Veterinarian;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
	
	public Veterinarian findByName(String name);
	
	public List<Veterinarian> findAll();
	
	public Veterinarian findById(long id);

}
