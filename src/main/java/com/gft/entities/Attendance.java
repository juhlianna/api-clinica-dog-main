package com.gft.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "tb_attendance")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date;	
	
	@DateTimeFormat(pattern="HH:mm:ss")
	private LocalTime hour;
	
	@NumberFormat(pattern="####.##")
	private Double cost;
	
	@ManyToOne
	@JoinColumn(name = "dog_id")
	private Dog dog;
	
	@ManyToOne
	@JoinColumn(name = "veterinarian_id")
	private Veterinarian veterinarian;
	
	@OneToOne
	@JoinColumn(name = "type_id")
	private TypeOfService typeOfService;
	
	public Attendance() {		
	}

	public Attendance(Long id, LocalDate date, LocalTime hour, Double cost, Dog dog, Veterinarian veterinarian,
			TypeOfService typeOfService) {
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
	
	//**COMPARAR PARA NÃO REPETIR CADASTROS IGUAIS**//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	

}
