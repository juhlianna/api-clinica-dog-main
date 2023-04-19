package com.gft.dto.veterinarianDTO;

import com.gft.entities.Veterinarian;

public class VeterinarianMapper {
	
	public static Veterinarian fromDTO(RegistryVeterinarianDTO dto) {
		
		return new Veterinarian(null, dto.getCrmv(), dto.getName(), dto.getAddress(), 
				dto.getTelephone(), dto.getAttendances());
	}
	
	public static ConsultationVeterinarianDTO fromEntity(Veterinarian veterinarian) {
		
		return new ConsultationVeterinarianDTO(veterinarian.getId(), veterinarian.getCrmv(), veterinarian.getName(),
				veterinarian.getAddress(), veterinarian.getTelephone(), veterinarian.getAttendances());
	}
	

}
