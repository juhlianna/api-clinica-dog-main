package com.gft.dto.examDTO;

import java.util.List;

import com.gft.entities.Chart;

public class ConsultationExamDTO {
	
	private Long id;
	
	private String name;
	
	private List<Chart> charts;
	
	public ConsultationExamDTO() {
		
	}

	public ConsultationExamDTO(Long id, String name, List<Chart> charts) {
		super();
		this.id = id;
		this.name = name;
		this.charts = charts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String nome) {
		this.name = nome;
	}

	public List<Chart> getCharts() {
		return charts;
	}

	public void setCharts(List<Chart> charts) {
		this.charts = charts;
	}
	
	

}
