package com.gft.dto.typeOfServiceDTO;

import com.gft.entities.TypeOfService;

public class TypeOfServiceMapper {
	
	public static TypeOfService fromDTO(RegistryTypeOfServiceDTO dto) {
		
		return new TypeOfService(null, dto.getTipo());
	}
	
	public static ConsultationTypeOfServiceDTO fromEntity(TypeOfService typeOfService) {
		
		return new ConsultationTypeOfServiceDTO(typeOfService.getId(), typeOfService.getTipo());
	}
	

}
