package com.gft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Veterinarian;
import com.gft.repositories.VeterinarianRepository;

@Service
public class VeterinarianService {
	
	private VeterinarianRepository veterinarianRepository;
	
	public VeterinarianService(VeterinarianRepository veterinarianRepository) {
		this.veterinarianRepository = veterinarianRepository;
	}
	
	//**SALVAR**//
	public Veterinarian saveVeterinarian(Veterinarian veterinarian) {
		
		return veterinarianRepository.save(veterinarian);
	
	}
	
	//**BUSCAR**//
	public Veterinarian searchById(long id) {
		
		return veterinarianRepository.findById(id);
	}
	
	//**ATUALIZAR**//
	public Veterinarian updateVeterinarian(Veterinarian veterinarian, Long id) {
		
		Veterinarian veterinarianOriginal = this.searchById(id);
		
		veterinarian.setId(veterinarianOriginal.getId());
		
		return veterinarianRepository.save(veterinarian);
	}		
	
	//**LISTAR**//
	public List<Veterinarian> searchAll(){		
		return (List<Veterinarian>) veterinarianRepository.findAll();
	}
	
	public Page<Veterinarian> searchAll(Pageable pageable){
		return veterinarianRepository.findAll(pageable);
	}
	
	
	//**EXCLUIR**//
	
	public void deleteVeterinarian(Long id) {
		Veterinarian veterinarianOriginal = this.searchById(id);
		
		veterinarianRepository.delete(veterinarianOriginal);
		
	}


}
