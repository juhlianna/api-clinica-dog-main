package com.gft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.chartDTO.ChartMapper;
import com.gft.dto.chartDTO.ConsultationChartDTO;
import com.gft.dto.chartDTO.RegistryChartDTO;
import com.gft.entities.Chart;
import com.gft.services.ChartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/chart")
@Api(value="API REST Dog")
@CrossOrigin(origins="*")
public class ChartController {
	
	@Autowired
	private final ChartService chartService;
	
	public ChartController(ChartService chartService) {
		this.chartService = chartService;
	}

	@GetMapping("/list")
	@ApiOperation(value="Retorna uma lista de prontuário")
	public ResponseEntity<Page<ConsultationChartDTO>> searchAll(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(chartService.searchAll(pageable).map(ChartMapper::fromEntity));			
		
	}	
	
	@GetMapping("{id}") 
	@ApiOperation(value="Retorna uma pesquisa por prontuário")
	public ResponseEntity<ConsultationChartDTO> searchAll(@PathVariable Long id){

		Chart chart = chartService.searchById(id);
		
		return ResponseEntity.ok(ChartMapper.fromEntity(chart));
	}
		
	@PostMapping("/post")
	@ApiOperation(value="Salva informações do prontuário")
	public ResponseEntity<ConsultationChartDTO> saveChart(@RequestBody RegistryChartDTO dto){
			
		Chart chart = chartService.saveChart(ChartMapper.fromDTO(dto));
			
		return ResponseEntity.ok(ChartMapper.fromEntity(chart));
		
		
	}
	
	@PutMapping("/put")
	@ApiOperation(value="Atualiza informações do prontuário")
	public ResponseEntity<ConsultationChartDTO> updateChart(@RequestBody RegistryChartDTO dto,
			@PathVariable Long id){
		
		try {
		
			Chart chart = chartService.updateChart(ChartMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(ChartMapper.fromEntity(chart));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="Exclui um prontuário")
	public ResponseEntity<ConsultationChartDTO> excluirChart(@PathVariable Long id){
		
		try {
			chartService.deleteChart(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
