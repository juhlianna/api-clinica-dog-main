package com.gft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Medicament;
import com.gft.repositories.MedicamentRepository;

@Service
public class MedicamentService {
	
	private MedicamentRepository medicamentRepository;
	
	public MedicamentService(MedicamentRepository medicamentRepository) {
		this.medicamentRepository = medicamentRepository;
	}
	
	//**SALVAR**//
	public Medicament saveMedicament(Medicament medicament) {
		
		return medicamentRepository.save(medicament);
	
	}
	
	//**BUSCAR**//
	public Medicament searchById(long id) {
		
		return medicamentRepository.findById(id);
	}
	
	//**ATUALIZAR**//
	public Medicament updateMedicament(Medicament medicament, Long id) {
		
		Medicament medicamentOriginal = this.searchById(id);
		
		medicament.setId(medicamentOriginal.getId());
		
		return medicamentRepository.save(medicament);
	}		
	
	//**LISTAR**//
	public List<Medicament> searchAll(){		
		return (List<Medicament>) medicamentRepository.findAll();
	}
	
	public Page<Medicament> searchAll(Pageable pageable){
		return medicamentRepository.findAll(pageable);
	}
	
	
	//**EXCLUIR**//	
	public void deleteMedicament(Long id) {
		Medicament medicamentOriginal = this.searchById(id);
		
		medicamentRepository.delete(medicamentOriginal);
		
	}


}
