package com.indra.app.service;

import java.util.List;

import com.indra.app.entities.Adopter;

public interface IService {

	boolean insert(Adopter p);
	List<Adopter> findAll();
	Adopter findById(long id);
	List<Adopter> findByEmail(String email);
	List<Adopter> findByLastName(String lastName);
	boolean update(Adopter p);
	boolean deleteById(long id);
	
}
