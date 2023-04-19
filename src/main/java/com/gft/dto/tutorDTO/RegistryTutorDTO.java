package com.gft.dto.tutorDTO;

import java.util.List;

import com.gft.entities.Dog;

public class RegistryTutorDTO {
	
	private String name;
	
	private String cpf;
	
	private String address;
	
	private String telephone;
	
	private List<Dog> dogs;
	
	public RegistryTutorDTO() {
		
	}

	public RegistryTutorDTO(String name, String cpf, String address, String telephone, List<Dog> dogs) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.telephone = telephone;
		this.dogs = dogs;
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
