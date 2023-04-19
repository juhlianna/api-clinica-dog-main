package com.gft.dto.medicamentDTO;

import java.util.List;

import com.gft.entities.Chart;

public class ConsultationMedicamentDTO {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private List<Chart> charts;
	
	public ConsultationMedicamentDTO() {
		
	}

	public ConsultationMedicamentDTO(Long id, String name, String description, List<Chart> charts) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.charts = charts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Chart> getCharts() {
		return charts;
	}

	public void setCharts(List<Chart> charts) {
		this.charts = charts;
	}
	
	

}
