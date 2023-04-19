package com.gft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Dog;
import com.gft.entities.Tutor;
import com.gft.repositories.DogRepository;

@Service
public class DogService {
	
	private DogRepository dogRepository;
	private TutorService tutorService;	
	
	
	public DogService(DogRepository dogRepository, TutorService tutorService) {
		this.dogRepository = dogRepository;
		this.tutorService = tutorService;
	}
	
	//**SALVAR**//
	public Dog saveDog(Dog dog, Long id) throws Exception {
		if(dog.getName().isEmpty()) {
			throw new Exception("Este campo do nome não pode ser vazio!");
		}
		if(dog.getBreed().isEmpty()) {
			throw new Exception("O campo raça é obrigatório!");
		}		
		Tutor tutor = tutorService.searchById(id);
		dog.setTutor(tutor);
		return dogRepository.save(dog);
	
	}
	
	//**BUSCAR**//
	public Dog searchById(long id) {
		
		return dogRepository.findById(id);
	}
	
	//**ATUALIZAR**//
	public Dog updateDog(Dog dog, Long id) {
		
		Dog dogOriginal = this.searchById(id);
		
		dog.setId(dogOriginal.getId());
		
		return dogRepository.save(dog);
	}		
	
	//**LISTAR**//
	public List<Dog> searchAll(){		
		return (List<Dog>) dogRepository.findAll();
	}
	
	public Page<Dog> searchAll(Pageable pageable){
		return dogRepository.findAll(pageable);
	}
	
	
	//**EXCLUIR**//
	
	public void deleteDog(Long id) {
		Dog dogOriginal = this.searchById(id);
		
		dogRepository.delete(dogOriginal);
		
	}

	

}
