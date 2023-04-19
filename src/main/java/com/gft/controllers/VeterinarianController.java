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

import com.gft.dto.veterinarianDTO.ConsultationVeterinarianDTO;
import com.gft.dto.veterinarianDTO.RegistryVeterinarianDTO;
import com.gft.dto.veterinarianDTO.VeterinarianMapper;
import com.gft.entities.Veterinarian;
import com.gft.services.VeterinarianService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/veterinarian")
@Api(value="API REST Dog")
@CrossOrigin(origins="*")
public class VeterinarianController {
	
	@Autowired
	private final VeterinarianService veterinarianService;
	
	public VeterinarianController(VeterinarianService veterinarianService) {
		this.veterinarianService = veterinarianService;
	}
	
	
	@GetMapping("{id}") 
	@ApiOperation(value="Retorna uma pesquisa por veterinário")
	public ResponseEntity<ConsultationVeterinarianDTO> searchId(@PathVariable Long id){

		Veterinarian Veterinarian = veterinarianService.searchById(id);
		
		return ResponseEntity.ok(VeterinarianMapper.fromEntity(Veterinarian));
	}
	
	@GetMapping("/list")
	@ApiOperation(value="Retorna uma lista de veterinários")
	public ResponseEntity<Page<ConsultationVeterinarianDTO>> searchAll(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(veterinarianService.searchAll(pageable).map(VeterinarianMapper::fromEntity));			
		
	}	
		
	@PostMapping("/post")
	@ApiOperation(value="Salva informações do veterinário")
	public ResponseEntity<ConsultationVeterinarianDTO> saveVeterinarian(@RequestBody RegistryVeterinarianDTO dto){
			
		Veterinarian Veterinarian = veterinarianService.saveVeterinarian(VeterinarianMapper.fromDTO(dto));
			
		return ResponseEntity.ok(VeterinarianMapper.fromEntity(Veterinarian));
		
		
	}
	
	@PutMapping("/put")
	@ApiOperation(value="Atualiza informações do veterinário")
	public ResponseEntity<ConsultationVeterinarianDTO> updateVeterinarian(@RequestBody RegistryVeterinarianDTO dto,
			@PathVariable Long id){
		
		try {
		
			Veterinarian Veterinarian = veterinarianService.updateVeterinarian(VeterinarianMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(VeterinarianMapper.fromEntity(Veterinarian));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="Exclui um veterinário")
	public ResponseEntity<ConsultationVeterinarianDTO> deleteVeterinarian(@PathVariable Long id){
		
		try {
			veterinarianService.deleteVeterinarian(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	

}
