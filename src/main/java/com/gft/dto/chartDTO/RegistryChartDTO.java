package com.gft.dto.chartDTO;

import java.util.List;

import com.gft.entities.Attendance;
import com.gft.entities.Exam;
import com.gft.entities.Medicament;

public class RegistryChartDTO {
	
	private Attendance attendance;
	
	private List<Exam> exams;
	
	private List<Medicament> medicaments;
	
	private String diagnostic;
	
	private String description;
	
	public RegistryChartDTO() {
		
	}

	public RegistryChartDTO(Attendance attendance, List<Exam> exams, List<Medicament> medicaments, String diagnostic,
			String description) {
		super();
		this.attendance = attendance;
		this.exams = exams;
		this.medicaments = medicaments;
		this.diagnostic = diagnostic;
		this.description = description;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
