package com.gft.dto.userDTO;

import com.gft.entities.User;

public class UserMapper {
	
	public static User fromDTO(RegistryUserDTO dto) {
		
		return new User(null, dto.getEmail(), dto.getPassword());
	}
	
	public static ConsultationUserDTO fromEntity(User user) {
		
		return new ConsultationUserDTO(user.getId(), user.getEmail(), user.getPassword());
	}

}
