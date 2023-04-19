package com.gft.dto.medicamentDTO;

import com.gft.entities.Medicament;

public class MedicamentMapper {
	
	public static Medicament fromDTO(RegistryMedicamentDTO dto) {
		
		return new Medicament(null, dto.getName(), dto.getDescription(), dto.getCharts());
	}
	
	public static ConsultationMedicamentDTO fromEntity( Medicament medicament) {
		
		return new ConsultationMedicamentDTO(medicament.getId(), medicament.getName(), 
				medicament.getDescription(), medicament.getCharts());
	}
	

}
