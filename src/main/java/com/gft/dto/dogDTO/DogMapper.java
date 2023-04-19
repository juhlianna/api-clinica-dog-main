package com.gft.dto.dogDTO;

import com.gft.dto.tutorDTO.TutorMapper;
import com.gft.entities.Dog;
import com.gft.entities.Tutor;

public class DogMapper {
	
	public static Dog fromDTO(RegistryDogDTO dto) {
		
		return new Dog(null, dto.getName(), dto.getBirthDate(), dto.getBreed(), new Tutor(dto.getIdTutor()), dto.getAttendances());
	}
	
	public static ConsultationDogDTO fromEntity(Dog dog) {
		
		return new ConsultationDogDTO(dog.getId(), dog.getName(), dog.getBirthDate(), dog.getBreed(),
				TutorMapper.fromEntity(dog.getTutor(), null), dog.getAttendances());
	}

}
