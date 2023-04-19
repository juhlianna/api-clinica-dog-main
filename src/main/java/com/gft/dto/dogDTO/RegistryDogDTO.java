package com.gft.dto.dogDTO;

import java.time.LocalDate;

import java.util.List;

import com.gft.entities.Attendance;


public class RegistryDogDTO {
	
	private String name;
	
	private LocalDate birthDate;
	
	private String breed;
	
	private Long idTutor;
	
	private List<Attendance> attendances;
	
	public RegistryDogDTO() {
		
	}

	public RegistryDogDTO(String name, LocalDate birthDate, String breed, Long idTutor, List<Attendance> attendances) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.breed = breed;
		this.idTutor = idTutor;
		this.attendances = attendances;
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

	public Long getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(Long idTutor) {
		this.idTutor = idTutor;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	
}
