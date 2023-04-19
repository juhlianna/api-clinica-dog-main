package com.gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.TypeOfService;

@Repository
public interface TypeOfServiceRepository extends JpaRepository<TypeOfService, Long>{
	
	public TypeOfService findByTipo(String tipo);
	
	public List<TypeOfService> findAll();
	
	public TypeOfService findById(long id);

}
