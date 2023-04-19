package com.gft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Exam;
import com.gft.repositories.ExamRepository;

@Service
public class ExamService {
	
	private ExamRepository examRepository;
	
	public ExamService(ExamRepository examRepository) {
		this.examRepository = examRepository;
	}
	
	//**SALVAR**//
	public Exam saveExam(Exam exam) {
		
		return examRepository.save(exam);
	
	}
	
	//**BUSCAR**//
	public Exam searchById(long id) {
		
		return examRepository.findById(id);
	}
	
	//**ATUALIZAR**//
	public Exam updateExam(Exam exam, Long id) {
		
		Exam examOriginal = this.searchById(id);
		
		exam.setId(examOriginal.getId());
		
		return examRepository.save(exam);
	}		
	
	//**LISTAR**//
	public List<Exam> searchAll(){		
		return (List<Exam>) examRepository.findAll();
	}
	
	public Page<Exam> searchAll(Pageable pageable){
		return examRepository.findAll(pageable);
	}
	
	
	//**EXCLUIR**//
	
	public void deleteExam(Long id) {
		Exam examOriginal = this.searchById(id);
		
		examRepository.delete(examOriginal);
		
	}

	
	

}
