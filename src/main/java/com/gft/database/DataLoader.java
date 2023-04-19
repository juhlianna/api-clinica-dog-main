package com.gft.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import com.gft.entities.Attendance;
import com.gft.entities.Dog;
import com.gft.entities.Tutor;
import com.gft.entities.TypeOfService;
import com.gft.entities.User;
import com.gft.repositories.DogRepository;
import com.gft.repositories.TutorRepository;
import com.gft.repositories.TypeOfServiceRepository;
import com.gft.repositories.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TypeOfServiceRepository typeOfServiceRepository;
	
	@Autowired
	TutorRepository tutorRepository;
	
	@Autowired
	DogRepository dogRepository;
	
	
	
	@Transactional
	public void run(String... args) throws Exception {
		
		//**NOVO USUÁRIO**//
		User user = new User(null,"admin@admin.com", "1234");		
		userRepository.save(user);	
		
		//**NOVO TIPO DE SERVIÇO**//
		TypeOfService typeOfService = new TypeOfService(null, "Consulta");		
		typeOfServiceRepository.save(typeOfService);
		
		//**NOVO DOG**//
		Dog dog = new Dog(null, "Sara", "20/12/2002", "Fila", null , null);
		dogRepository.save(dog);
				
		
		//**NOVO TUTOR**//
		Tutor tutor = new Tutor(null, "Marcos", "123456789", "Rua 1, 20 Jd Cidade ", "(12) 99887755", null);
		tutorRepository.save(tutor);
		
		
		
		
		
	}
	
	

	
	


	
	
	
	
	
	
	




}
