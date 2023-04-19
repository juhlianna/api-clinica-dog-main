package com.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gft.entities.User;
import com.gft.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User buscarUsuarioPorEmail(String email) {
		Optional<User> optional = userRepository.findByEmail(email);
		
		if(optional.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return optional.get();		
		
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return buscarUsuarioPorEmail(username);
		
	}

	public User buscarUsuarioPorId(Long id) {
		Optional<User> optional = userRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new RuntimeException("Usuário não encontrado");
		}
		
		return optional.get();
		
	}
	
	 public User updateUser(User user)	 {
		 return userRepository.save(user);
		 
	 }

	

	public User salvarUser(User user) {
		
		return userRepository.save(user);
		
	}
	
	public List<User> listar(){
    	return userRepository.findAll();
    	}
	
	public void excluirUsuario(Long id) {
		User usuario = buscarUsuarioPorId(id);
		if (usuario != null) {
			userRepository.delete(usuario);		
		}
	}

	public void salvarUsuario(Long id) {
		// TODO Auto-generated method stub
		
	}


	
	
}
