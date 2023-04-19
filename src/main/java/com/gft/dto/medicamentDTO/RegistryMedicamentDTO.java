package com.gft.dto.medicamentDTO;

import java.util.List;

import com.gft.entities.Chart;

public class RegistryMedicamentDTO {
	
	private String name;
	
	private String description;
	
	private List<Chart> charts;
	
	public RegistryMedicamentDTO() {
		
	}

	public RegistryMedicamentDTO(String name, String description, List<Chart> charts) {
		super();
		this.name = name;
		this.description = description;
		this.charts = charts;
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
