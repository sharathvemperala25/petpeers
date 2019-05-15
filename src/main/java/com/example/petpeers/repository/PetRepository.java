package com.example.petpeers.repository;

import org.hamcrest.Matcher;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.petpeers.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

	
	
	
}
