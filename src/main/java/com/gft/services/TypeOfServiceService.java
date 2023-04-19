package com.gft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.TypeOfService;
import com.gft.repositories.TypeOfServiceRepository;

@Service
public class TypeOfServiceService {
	
	private TypeOfServiceRepository typeOfServiceRepository;
	
	public TypeOfServiceService(TypeOfServiceRepository typeOfServiceRepository) {
		this.typeOfServiceRepository = typeOfServiceRepository;
	}
	
	//**SALVAR**//
	public TypeOfService saveTypeOfService(TypeOfService typeOfService) {
		
		return typeOfServiceRepository.save(typeOfService);
	
	}
	
	//**BUSCAR**//
	public TypeOfService searchById(long id) {
		
		return typeOfServiceRepository.findById(id);
	}
	
	//**ATUALIZAR**//
	public TypeOfService updateTypeOfService(TypeOfService typeOfService, Long id) {
		
		TypeOfService typeOfServiceOriginal = this.searchById(id);
		
		typeOfService.setId(typeOfServiceOriginal.getId());
		
		return typeOfServiceRepository.save(typeOfService);
	}		
	
	//**LISTAR**//
	public List<TypeOfService> searchAll(){		
		return (List<TypeOfService>) typeOfServiceRepository.findAll();
	}
	
	public Page<TypeOfService> searchAll(Pageable pageable){
		return typeOfServiceRepository.findAll(pageable);
	}
	
	
	//**EXCLUIR**//
	
	public void deleteTypeOfService(Long id) {
		TypeOfService typeOfServiceOriginal = this.searchById(id);
		
		typeOfServiceRepository.delete(typeOfServiceOriginal);
		
	}

		

}
