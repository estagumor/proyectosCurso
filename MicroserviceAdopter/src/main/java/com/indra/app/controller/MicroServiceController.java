package com.indra.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.indra.app.entities.Adopter;
import com.indra.app.exception.AdopterNotFoundException;
import com.indra.app.service.IService;

@RestController //JSON
@RequestMapping("/adopters") //https://ip:port/pets
public class MicroServiceController {
	private IService service;
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(MicroServiceController.class);
	
	public MicroServiceController(IService service) {
		this.service=service;
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Adopter p) {
		try {
			if(service.insert(p)) {
				return new ResponseEntity<>("OK", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
			}
		} catch(Exception ex) {
			LOGGER.error("INSERT {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Adopter>> findAll() {
		try {
			return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
		} catch(AdopterNotFoundException ex) {
			LOGGER.warn("FINDALL {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception ex) {
			LOGGER.error("FINDALL {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/id")
	public ResponseEntity<Adopter> findById(@RequestParam long id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch(AdopterNotFoundException ex) {
			LOGGER.warn("FINDBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			LOGGER.error("FINDBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/email")
	public ResponseEntity<List<Adopter>> findByEmail(@RequestParam String email) {
		try {
			return new ResponseEntity<>(service.findByEmail(email), HttpStatus.OK);
		} catch(AdopterNotFoundException ex) {
			LOGGER.warn("FINDBYEMAIL {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			LOGGER.error("FINDBYEMAIL {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/lastname")
	public ResponseEntity<List<Adopter>> findByLastName(@RequestParam String lastName) {
		try {
			return new ResponseEntity<>(service.findByLastName(lastName), HttpStatus.OK);
		} catch(AdopterNotFoundException ex) {
			LOGGER.warn("FINDBYLASTNAME {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			LOGGER.error("FINDBYLASTNAME {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<Boolean> updateById(@RequestBody Adopter p) {
		try {
			return new ResponseEntity<>(service.update(p), HttpStatus.OK);
		} catch(AdopterNotFoundException ex) {
			LOGGER.warn("UPDATEBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			LOGGER.error("UPDATEBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteById(@RequestParam long id) {
		try {
			return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
		} catch(AdopterNotFoundException ex) {
			LOGGER.warn("DELETEBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch(Exception ex) {
			LOGGER.error("DELETEBYID {}", ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
