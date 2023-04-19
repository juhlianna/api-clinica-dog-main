package com.gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.Chart;

@Repository
public interface ChartRepository extends JpaRepository<Chart, Long> {
	
	public List<Chart> findAll();
	
	public Chart findById(long id);

}
