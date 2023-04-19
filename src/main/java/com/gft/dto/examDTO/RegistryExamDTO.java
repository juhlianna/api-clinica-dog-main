package com.gft.dto.examDTO;

import java.util.List;

import com.gft.entities.Chart;

public class RegistryExamDTO {
	
	private String name;
	
	private List<Chart> charts;
	
	public RegistryExamDTO() {
		
	}

	public RegistryExamDTO(String name, List<Chart> charts) {
		super();
		this.name = name;
		this.charts = charts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chart> getCharts() {
		return charts;
	}

	public void setCharts(List<Chart> charts) {
		this.charts = charts;
	}
	
	

}
