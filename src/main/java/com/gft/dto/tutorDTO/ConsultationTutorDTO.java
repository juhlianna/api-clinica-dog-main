package com.gft.dto.tutorDTO;

import java.util.List;

import com.gft.entities.Dog;

public class ConsultationTutorDTO {
	
	private Long id;
	
	private String name;
	
	private String cpf;
	
	private String address;
	
	private String telephone;
	
	private List<Dog> dogs;
	
	public ConsultationTutorDTO() {
		
	}

	public ConsultationTutorDTO(Long id, String name, String cpf, String address, String telephone, List<Dog> dogs) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.telephone = telephone;
		this.dogs = dogs;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}
	
	

}
