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

import com.gft.dto.examDTO.ConsultationExamDTO;
import com.gft.dto.examDTO.ExamMapper;
import com.gft.dto.examDTO.RegistryExamDTO;
import com.gft.entities.Exam;
import com.gft.services.ExamService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/exam")
@Api(value="API REST Dog")
@CrossOrigin(origins="*")
public class ExamController {
	
	@Autowired
	private final ExamService examService;
	
	public ExamController(ExamService examService) {
		this.examService = examService;
	}

	@GetMapping("/list")
	@ApiOperation(value="Retorna uma lista de exames")
	public ResponseEntity<Page<ConsultationExamDTO>> searchAll(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(examService.searchAll(pageable).map(ExamMapper::fromEntity));			
		
	}	
	
	@GetMapping("{id}") 
	@ApiOperation(value="Retorna uma pesquisa por exame")
	public ResponseEntity<ConsultationExamDTO> searchAll(@PathVariable Long id){

		Exam exam = examService.searchById(id);
		
		return ResponseEntity.ok(ExamMapper.fromEntity(exam));
	}
		
	@PostMapping("/post")
	@ApiOperation(value="Salva informações do exame")
	public ResponseEntity<ConsultationExamDTO> saveExam(@RequestBody RegistryExamDTO dto){
			
		Exam exam = examService.saveExam(ExamMapper.fromDTO(dto));
			
		return ResponseEntity.ok(ExamMapper.fromEntity(exam));
		
		
	}
	
	@PutMapping("/put")
	@ApiOperation(value="Atualiza informações do exame")
	public ResponseEntity<ConsultationExamDTO> updateExam(@RequestBody RegistryExamDTO dto,
			@PathVariable Long id){
		
		try {
		
			Exam exam = examService.updateExam(ExamMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(ExamMapper.fromEntity(exam));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="Exclui informações do exame")
	public ResponseEntity<ConsultationExamDTO> excluirExam(@PathVariable Long id){
		
		try {
			examService.deleteExam(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
