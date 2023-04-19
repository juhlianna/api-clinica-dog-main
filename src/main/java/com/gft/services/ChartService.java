package com.gft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Chart;
import com.gft.repositories.ChartRepository;

@Service
public class ChartService {
	
	private ChartRepository chartRepository;
	
	public ChartService(ChartRepository chartRepository) {
		this.chartRepository = chartRepository;
	}
	
	//**SALVAR**//
	public Chart saveChart(Chart chart) {
		
		return chartRepository.save(chart);
	
	}
	
	//**BUSCAR**//
	public Chart searchById(long id) {
		
		return chartRepository.findById(id);
	}
	
	//**ATUALIZAR**//
	public Chart updateChart(Chart chart, Long id) {
		
		Chart chartOriginal = this.searchById(id);
		
		chart.setId(chartOriginal.getId());
		
		return chartRepository.save(chart);
	}		
	
	//**LISTAR**//
	public List<Chart> searchAll(){		
		return (List<Chart>) chartRepository.findAll();
	}
	
	public Page<Chart> searchAll(Pageable pageable){
		return chartRepository.findAll(pageable);
	}
	
	
	//**EXCLUIR**//
	
	public void deleteChart(Long id) {
		Chart chartOriginal = this.searchById(id);
		
		chartRepository.delete(chartOriginal);
		
	}

}
