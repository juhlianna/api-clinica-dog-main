package com.gft.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veterinarian")
public class Veterinarian {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String crmv;
	
	private String name;
	
	private String address;
	
	private String telephone;
	
	@OneToMany(mappedBy="veterinarian")
	private List<Attendance> attendances;
	
	public Veterinarian() {		
	}	
	
	public Veterinarian(Long id, String crmv, String name, String address, String telephone,
			List<Attendance> attendances) {
		super();
		this.id = id;
		this.crmv = crmv;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.attendances = attendances;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	//**COMPARAR PARA NÃO REPETIR CADASTROS IGUAIS**//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crmv == null) ? 0 : crmv.hashCode());
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
		Veterinarian other = (Veterinarian) obj;
		if (crmv == null) {
			if (other.crmv != null)
				return false;
		} else if (!crmv.equals(other.crmv))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
