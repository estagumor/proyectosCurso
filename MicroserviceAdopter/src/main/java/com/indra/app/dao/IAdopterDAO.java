package com.indra.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.app.entities.Adopter;

public interface IAdopterDAO extends CrudRepository<Adopter, Long>{

	@Query("SELECT u FROM Adopter u WHERE u.email = :email")
	Optional<List<Adopter>> findByEmail(String email);
	
	@Query("SELECT u FROM Adopter u WHERE u.lastName = :lastName")
	Optional<List<Adopter>> findByLastName(String lastName);
}
