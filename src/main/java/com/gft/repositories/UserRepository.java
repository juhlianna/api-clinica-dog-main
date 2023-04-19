package com.gft.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.entities.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {	

	Optional<User> findByEmail(String email);

	Optional<User> findById(Long id);

}
