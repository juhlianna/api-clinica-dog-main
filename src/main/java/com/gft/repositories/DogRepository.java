package com.gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
	
	public Dog findByName(String name);
	
	public List<Dog> findAll();
	
	public Dog findById(long id);

}
