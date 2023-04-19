package com.gft.dto.attendanceDTO;

import java.time.LocalDate;
import java.time.LocalTime;

import com.gft.entities.Dog;
import com.gft.entities.TypeOfService;
import com.gft.entities.Veterinarian;

public class RegistryAttendanceDTO {
	
	private LocalDate date;
	
	private LocalTime hour;
	
	private Double cost;

	private Dog dog;
	
	private Veterinarian veterinarian;
	
	private TypeOfService typeOfService;
	
	public RegistryAttendanceDTO() {		
	}

	public RegistryAttendanceDTO(LocalDate date, LocalTime hour, Double cost, Dog dog, Veterinarian veterinarian,
			TypeOfService typeOfService) {
		super();
		this.date = date;
		this.hour = hour;
		this.cost = cost;
		this.dog = dog;
		this.veterinarian = veterinarian;
		this.typeOfService = typeOfService;
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
