package com.gft.dto.dogDTO;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.gft.dto.tutorDTO.ConsultationTutorDTO;
import com.gft.entities.Attendance;


public class ConsultationDogDTO {
	
	private Long id;
	
	private String name;
	
	private LocalDate birthDate;
	
	private String breed;
	
	private ConsultationTutorDTO tutor;
	
	private List<Attendance> attendances;
	
	public ConsultationDogDTO() {
		
	}

	public ConsultationDogDTO(Long id, String name, LocalDate birthDate, String breed, ConsultationTutorDTO tutor,
			List<Attendance> attendances) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.breed = breed;
		this.tutor = tutor;
		this.attendances = attendances;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public ConsultationTutorDTO getTutor() {
		return tutor;
	}

	public void setTutor(ConsultationTutorDTO tutor) {
		this.tutor = tutor;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	
	
	
	
	

}
