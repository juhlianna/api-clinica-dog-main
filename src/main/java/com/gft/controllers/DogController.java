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

import com.gft.dto.dogDTO.ConsultationDogDTO;
import com.gft.dto.dogDTO.DogMapper;
import com.gft.dto.dogDTO.RegistryDogDTO;
import com.gft.entities.Dog;
import com.gft.services.DogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("v1/dog")
@Api(value="API REST Dog")
@CrossOrigin(origins="*")
public class DogController {
	
	@Autowired
	private DogService dogService;		
	
	public DogController(DogService dogService) {
		this.dogService = dogService;
	}
	
	@GetMapping("{id}") 
	@ApiOperation(value="Retorna uma pesquisa por cachorro")
	public ResponseEntity<ConsultationDogDTO> searchId(@PathVariable Long id){

		Dog dog = dogService.searchById(id);
		
		return ResponseEntity.ok(DogMapper.fromEntity(dog));
	}
	
	@GetMapping("/list")
	@ApiOperation(value="Retorna uma lista de cachorros")
	public ResponseEntity<Page<ConsultationDogDTO>> searchAll(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(dogService.searchAll(pageable).map(DogMapper::fromEntity));
	}	
		
	@PostMapping("/post")
	@ApiOperation(value="Salva informações do cachorro")
	public ResponseEntity<ConsultationDogDTO> saveDog(@PathVariable("Id_Tutor") Long id, @RequestBody RegistryDogDTO dto) throws Exception {		
		
		return ResponseEntity.ok(DogMapper.fromEntity(dogService.saveDog(DogMapper.fromDTO(dto), id)));
	}
	
	@PutMapping("/put")
	@ApiOperation(value="Atualiza informações do cachorro")
	public ResponseEntity<ConsultationDogDTO> updateDog(@RequestBody RegistryDogDTO dto, @PathVariable Long id){
		
		try {
		
			Dog dog = dogService.updateDog(DogMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(DogMapper.fromEntity(dog));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}	
		
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="Exclui informações do cachorro")
	public ResponseEntity<ConsultationDogDTO> deleteDog(@PathVariable Long id){
		
		try {
			dogService.deleteDog(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
		
	
		
		
		
		
		
		
		
	
	
	

}
