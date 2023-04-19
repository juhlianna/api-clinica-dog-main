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

import com.gft.dto.tutorDTO.ConsultationTutorDTO;
import com.gft.dto.tutorDTO.RegistryTutorDTO;
import com.gft.dto.tutorDTO.TutorMapper;
import com.gft.entities.Tutor;
import com.gft.services.TutorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/tutor")
@Api(value="API REST Dog")
@CrossOrigin(origins="*")
public class TutorController {
	
	@Autowired
	private final TutorService tutorService;
	
	public TutorController(TutorService tutorService) {
		this.tutorService = tutorService;
	}

	
	@GetMapping("/list")
	@ApiOperation(value="Retorna uma lista de donos")
	public ResponseEntity<Page<Tutor>> searchAll(@PageableDefault Pageable pageable){		
		
		return ResponseEntity.ok(tutorService.searchAll(pageable));

	}	
	
	@GetMapping("{id}") 
	@ApiOperation(value="Retorna uma pesquisa por dono")
	public ResponseEntity<ConsultationTutorDTO> searchAll(@PathVariable Long id){

		Tutor tutor = tutorService.searchById(id);
		
		return ResponseEntity.ok(TutorMapper.fromEntity(tutor, null));
	}
		
	@PostMapping("/post")
	@ApiOperation(value="Salva informações do dono")
	public ResponseEntity<ConsultationTutorDTO> saveTutor(@RequestBody RegistryTutorDTO dto){
			
		Tutor tutor = tutorService.saveTutor(TutorMapper.fromDTO(dto));
			
		return ResponseEntity.ok(TutorMapper.fromEntity(tutor, null));
		
		
	}
	
	@PutMapping("/put")
	@ApiOperation(value="Atualiza informações do dono")
	public ResponseEntity<ConsultationTutorDTO> updateTutor(@RequestBody RegistryTutorDTO dto,
			@PathVariable Long id){
		
		try {
		
			Tutor tutor = tutorService.updateTutor(TutorMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(TutorMapper.fromEntity(tutor, null));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="Exclui um dono")
	public ResponseEntity<ConsultationTutorDTO> excluirTutor(@PathVariable Long id){
		
		try {
			tutorService.deleteTutor(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	

}
