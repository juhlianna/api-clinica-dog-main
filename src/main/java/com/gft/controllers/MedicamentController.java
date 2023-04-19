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

import com.gft.dto.medicamentDTO.ConsultationMedicamentDTO;
import com.gft.dto.medicamentDTO.MedicamentMapper;
import com.gft.dto.medicamentDTO.RegistryMedicamentDTO;
import com.gft.entities.Medicament;
import com.gft.services.MedicamentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/medicament")
@Api(value="API REST Dog")
@CrossOrigin(origins="*")
public class MedicamentController {
	
	@Autowired
	private final MedicamentService medicamentService;
	
	public MedicamentController(MedicamentService medicamentService) {
		this.medicamentService = medicamentService;
	}

	@GetMapping("/list")
	@ApiOperation(value="Retorna uma lista de medicamentos")
	public ResponseEntity<Page<ConsultationMedicamentDTO>> searchAll(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(medicamentService.searchAll(pageable).map(MedicamentMapper::fromEntity));			
		
	}	
	
	@GetMapping("{id}") 
	@ApiOperation(value="Retorna uma pesquisa por medicamento")
	public ResponseEntity<ConsultationMedicamentDTO> searchAll(@PathVariable Long id){

		Medicament medicament = medicamentService.searchById(id);
		
		return ResponseEntity.ok(MedicamentMapper.fromEntity(medicament));
	}
		
	@PostMapping("/post")
	@ApiOperation(value="Salva informações do medicamento")
	public ResponseEntity<ConsultationMedicamentDTO> saveMedicament(@RequestBody RegistryMedicamentDTO dto){
			
		Medicament medicament = medicamentService.saveMedicament(MedicamentMapper.fromDTO(dto));
			
		return ResponseEntity.ok(MedicamentMapper.fromEntity(medicament));
		
		
	}
	
	@PutMapping("/put")
	@ApiOperation(value="Atualiza informações do medicamento")
	public ResponseEntity<ConsultationMedicamentDTO> updateMedicament(@RequestBody RegistryMedicamentDTO dto,
			@PathVariable Long id){
		
		try {
		
			Medicament medicament = medicamentService.updateMedicament(MedicamentMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(MedicamentMapper.fromEntity(medicament));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="Exclui um medicamento")
	public ResponseEntity<ConsultationMedicamentDTO> excluirMedicament(@PathVariable Long id){
		
		try {
			medicamentService.deleteMedicament(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
