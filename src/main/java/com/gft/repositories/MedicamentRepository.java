package com.gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Medicament;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
	
	public Medicament findByName(String name);
	
	public List<Medicament> findAll();
	
	public Medicament findById(long id);	

}
