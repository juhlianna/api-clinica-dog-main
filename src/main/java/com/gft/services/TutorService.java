package com.gft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Tutor;
import com.gft.repositories.TutorRepository;

@Service
public class TutorService {
	
	private TutorRepository tutorRepository;
	
	public TutorService(TutorRepository tutorRepository) {
		this.tutorRepository = tutorRepository;
	}
	
	//**SALVAR**//
	public Tutor saveTutor(Tutor tutor) {
		
		return tutorRepository.save(tutor);
	
	}
	
	//**BUSCAR**//
	public Tutor searchById(long id) {
		
		return tutorRepository.findById(id);
	}
	
	//**ATUALIZAR**//
	public Tutor updateTutor(Tutor tutor, Long id) {
		
		Tutor tutorOriginal = this.searchById(id);
		
		tutor.setId(tutorOriginal.getId());
		
		return tutorRepository.save(tutor);
	}		
	
	//**LISTAR**//
	public List<Tutor> searchAll(){		
		return (List<Tutor>) tutorRepository.findAll();
	}
	
	public Page<Tutor> searchAll(Pageable pageable){
		return tutorRepository.findAll(pageable);
	}
	
	
	//**EXCLUIR**//
	
	public void deleteTutor(Long id) {
		Tutor tutorOriginal = this.searchById(id);
		
		tutorRepository.delete(tutorOriginal);
		
	}


}
