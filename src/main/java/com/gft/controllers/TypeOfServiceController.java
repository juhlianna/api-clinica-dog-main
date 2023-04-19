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

import com.gft.dto.typeOfServiceDTO.ConsultationTypeOfServiceDTO;
import com.gft.dto.typeOfServiceDTO.RegistryTypeOfServiceDTO;
import com.gft.dto.typeOfServiceDTO.TypeOfServiceMapper;
import com.gft.entities.TypeOfService;
import com.gft.services.TypeOfServiceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/typeOfService")
@Api(value="API REST Dog")
@CrossOrigin(origins="*")
public class TypeOfServiceController {
	
	@Autowired
	private final TypeOfServiceService typeOfServiceService;
	
	public TypeOfServiceController(TypeOfServiceService typeOfServiceService) {
		this.typeOfServiceService = typeOfServiceService;
	}

	@GetMapping("/list")
	@ApiOperation(value="Retorna uma lista de tipos de serviço")
	public ResponseEntity<Page<ConsultationTypeOfServiceDTO>> searchAll(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(typeOfServiceService.searchAll(pageable).map(TypeOfServiceMapper::fromEntity));			
		
	}	
	
	@GetMapping("{id}") 
	@ApiOperation(value="Retorna uma pesquisa por tipo de serviço")
	public ResponseEntity<ConsultationTypeOfServiceDTO> searchAll(@PathVariable Long id){

		TypeOfService typeOfService = typeOfServiceService.searchById(id);
		
		return ResponseEntity.ok(TypeOfServiceMapper.fromEntity(typeOfService));
	}
		
	@PostMapping("/post")
	@ApiOperation(value="Salva informações do tipo de serviço")
	public ResponseEntity<ConsultationTypeOfServiceDTO> saveTypeOfService(@RequestBody RegistryTypeOfServiceDTO dto){
			
		TypeOfService typeOfService = typeOfServiceService.saveTypeOfService(TypeOfServiceMapper.fromDTO(dto));
			
		return ResponseEntity.ok(TypeOfServiceMapper.fromEntity(typeOfService));
		
		
	}
	
	@PutMapping("/put")
	@ApiOperation(value="Atualiza informações do tipo de serviço")
	public ResponseEntity<ConsultationTypeOfServiceDTO> updateTypeOfService(@RequestBody RegistryTypeOfServiceDTO dto,
			@PathVariable Long id){
		
		try {
		
			TypeOfService typeOfService = typeOfServiceService.updateTypeOfService(TypeOfServiceMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(TypeOfServiceMapper.fromEntity(typeOfService));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="Exclui um tipo de serviço")
	public ResponseEntity<ConsultationTypeOfServiceDTO> excluirTypeOfService(@PathVariable Long id){
		
		try {
			typeOfServiceService.deleteTypeOfService(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
