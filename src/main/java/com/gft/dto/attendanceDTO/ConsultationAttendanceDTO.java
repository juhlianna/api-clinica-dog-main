package com.gft.dto.attendanceDTO;

import java.time.LocalDate;
import java.time.LocalTime;

import com.gft.entities.Dog;
import com.gft.entities.TypeOfService;
import com.gft.entities.Veterinarian;

public class ConsultationAttendanceDTO {
	
	private Long id;
	
	private LocalDate date;
	
	private LocalTime hour;
	
	private Double cost;

	private Dog dog;
	
	private Veterinarian veterinarian;
	
	private TypeOfService typeOfService;
	
	public ConsultationAttendanceDTO() {
		
	}

	public ConsultationAttendanceDTO(Long id, LocalDate date, LocalTime hour, Double cost, Dog dog,
			Veterinarian veterinarian, TypeOfService typeOfService) {
		super();
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.cost = cost;
		this.dog = dog;
		this.veterinarian = veterinarian;
		this.typeOfService = typeOfService;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public Veterinarian getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(Veterinarian veterinarian) {
		this.veterinarian = veterinarian;
	}

	public TypeOfService getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(TypeOfService typeOfService) {
		this.typeOfService = typeOfService;
	}

	
	

}
