package com.gft.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.entities.Attendance;

import com.gft.repositories.AttendanceRepository;

@Service
public class AttendanceService {
	 
	private AttendanceRepository attendanceRepository;
	
	public AttendanceService(AttendanceRepository attendanceRepository) {
		this.attendanceRepository = attendanceRepository;
	}
	
	//**SALVAR**//
	public Attendance saveAttendance(Attendance attendance) {
		
		return attendanceRepository.save(attendance);
	
	}
	
	//**BUSCAR**//
	public Attendance searchById(long id) {
		
		return attendanceRepository.findById(id);		
	
	}
	
	//**ATUALIZAR**//
	public Attendance updateAttendance(Attendance attendance, Long id) {
		
		Attendance attendanceOriginal = this.searchById(id);
		
		attendance.setId(attendanceOriginal.getId());
		
		return attendanceRepository.save(attendance);
	}		
	
	//**LISTAR**//
	public List<Attendance> searchAll(){		
		return (List<Attendance>) attendanceRepository.findAll();
	}
	
	public Page<Attendance> searchAll(Pageable pageable){
		return attendanceRepository.findAll(pageable);
	}
	
	//**EXCLUIR**//
	
		public void deleteAttendance(Long id) {
			Attendance attendancetOriginal = this.searchById(id);
			
			attendanceRepository.delete(attendancetOriginal);
			
		}

}
