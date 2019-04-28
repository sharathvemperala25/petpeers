package com.example.petpeers.service;

import java.util.List;

import com.example.petpeers.entity.Pet;

public interface PetService {
	
	boolean savePet(Pet pet);
	List<Pet> getAllPets();

}
