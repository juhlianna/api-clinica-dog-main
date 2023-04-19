package com.gft.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.dto.userDTO.ConsultationUserDTO;
import com.gft.dto.userDTO.RegistryUserDTO;
import com.gft.dto.userDTO.UserMapper;
import com.gft.entities.User;
import com.gft.services.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("v1/user")
@Api(value="API REST Dog")
@CrossOrigin(origins="*")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<ConsultationUserDTO> salvarUsuario(@RequestBody RegistryUserDTO dto){
			
			User user = userService.salvarUser(UserMapper.fromDTO(dto));
			
			return ResponseEntity.ok(UserMapper.fromEntity(user));
			
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ConsultationUserDTO>> Listar_Usuarios() {
		return ResponseEntity.ok(userService.listar().stream()
				.map(UserMapper::fromEntity)
				.collect(Collectors.toList()));
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultationUserDTO> Achar_Usuario(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity.ok(UserMapper.fromEntity(userService.buscarUsuarioPorId(id)));
	}
	@PutMapping("/put")
	public ResponseEntity<ConsultationUserDTO> Atualizar_Usuario(@PathVariable("id")Long id,@RequestBody User user) throws Exception{
		return ResponseEntity.ok(UserMapper.fromEntity(userService.updateUser(user)));
	}
	@DeleteMapping("/delete")
	public ResponseEntity<List<ConsultationUserDTO>> Excluir_Usuario(@PathVariable("id") User id) throws Exception{
		userService.salvarUser(id);
		return ResponseEntity.ok(userService.listar().stream()
				.map(UserMapper::fromEntity)
				.collect(Collectors.toList()));
	}


}
