package com.gft.dto.tutorDTO;

import java.util.List;


import com.gft.entities.Attendance;
import com.gft.entities.Tutor;

public class TutorMapper {
	
	
	public static Tutor fromDTO(RegistryTutorDTO dto) {
		
		return new Tutor(null, dto.getName(), dto.getCpf(), dto.getAddress(), dto.getTelephone(), dto.getDogs());
	}
	
	public static ConsultationTutorDTO fromEntity(Tutor tutor, List<Attendance> list) {
		
		return new ConsultationTutorDTO(tutor.getId(), tutor.getName(), tutor.getCpf(), 
				tutor.getAddress(), tutor.getTelephone(), tutor.getDogs());
		
	}
	

}
