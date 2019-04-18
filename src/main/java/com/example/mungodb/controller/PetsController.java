package com.example.mungodb.controller;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mungodb.model.Pets;
import com.example.mungo.repository.PetsRepository;
import com.mongodb.MongoClient;

/*
 * Controller Class for Messaging Service
 */

@RestController
@RequestMapping("/pets")
public class PetsController {
  @Autowired(required=true)
  private PetsRepository repository;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/*
	 * {id} : Messenger Id - Get the message for the Id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Pets> getAllPets(@PathVariable String id) {
	  return repository.findByBreed(id);
	}
	    
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Pets createPet(@Valid @RequestBody Pets pets) {
	  pets.set_id(ObjectId.get());
	  repository.save(pets);
	  return pets;
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public void deletePet(@PathVariable String id) {
//	  repository.delete(repository.findByBreed(id));
//	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets) {
	  pets.set_id(id);
	  repository.save(pets);
	}
	
	}

