package com.example.mungo.repository;

import java.util.List;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mungodb.model.Pets;
@Repository
public interface PetsRepository extends MongoRepository<Pets, String> {
	  Pets findBy_id(ObjectId _id);
	  List<Pets> findByBreed(String breed);
	  List<Pets> findAll();
	}