package com.gft.dto.examDTO;

import com.gft.entities.Exam;

public class ExamMapper {
	
	public static Exam fromDTO(RegistryExamDTO dto) {
		
		return new Exam(null, dto.getName(), dto.getCharts());		
		
	}
	
	public static ConsultationExamDTO fromEntity(Exam exam) {
		
		return new ConsultationExamDTO(exam.getId(), exam.getName(), exam.getCharts());
	}
	

}
