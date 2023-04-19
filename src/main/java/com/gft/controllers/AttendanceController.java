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

import com.gft.dto.attendanceDTO.AttendanceMapper;
import com.gft.dto.attendanceDTO.ConsultationAttendanceDTO;
import com.gft.dto.attendanceDTO.RegistryAttendanceDTO;
import com.gft.entities.Attendance;
import com.gft.services.AttendanceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/attendance")
@Api(value="API REST Dog")
@CrossOrigin(origins="*")
public class AttendanceController {
	
	@Autowired
	private final AttendanceService attendanceService;
	
	public AttendanceController(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

	@GetMapping("/list")
	@ApiOperation(value="Retorna uma lista de atendimentos")
	public ResponseEntity<Page<ConsultationAttendanceDTO>> searchAll(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(attendanceService.searchAll(pageable).map(AttendanceMapper::fromEntity));			
		
	}	
	
	@GetMapping("{id}") 
	@ApiOperation(value="Retorna uma pesquisa por atendimento")
	public ResponseEntity<ConsultationAttendanceDTO> searchAll(@PathVariable Long id){

		Attendance attendance = attendanceService.searchById(id);
		
		return ResponseEntity.ok(AttendanceMapper.fromEntity(attendance));
	}
		
	@PostMapping("/post")
	@ApiOperation(value="Salva informações do atendimento")
	public ResponseEntity<ConsultationAttendanceDTO> saveAttendance(@RequestBody RegistryAttendanceDTO dto){
			
		Attendance attendance = attendanceService.saveAttendance(AttendanceMapper.fromDTO(dto));
			
		return ResponseEntity.ok(AttendanceMapper.fromEntity(attendance));
		
		
	}
	
	@PutMapping("/put")
	@ApiOperation(value="Atualiza informações do atendimento")
	public ResponseEntity<ConsultationAttendanceDTO> updateAttendance(@RequestBody RegistryAttendanceDTO dto,
			@PathVariable Long id){
		
		try {
		
			Attendance attendance = attendanceService.updateAttendance(AttendanceMapper.fromDTO(dto), id);
			
			return ResponseEntity.ok(AttendanceMapper.fromEntity(attendance));
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/delete")
	@ApiOperation(value="Exclui um atendimento")
	public ResponseEntity<ConsultationAttendanceDTO> excluirAttendance(@PathVariable Long id){
		
		try {
			attendanceService.deleteAttendance(id);
			
			return ResponseEntity.ok().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
