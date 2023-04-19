package com.gft.dto.veterinarianDTO;

import java.util.List;

import com.gft.entities.Attendance;

public class ConsultationVeterinarianDTO {
	
	private Long id;
	
	private String crmv;
	
	private String name;
	
	private String address;
	
	private String telephone;
	
	private List<Attendance> attendances;
	
	public ConsultationVeterinarianDTO() {
		
	}

	public ConsultationVeterinarianDTO(Long id, String crmv, String name, String address, String telephone,
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
	
	

}
