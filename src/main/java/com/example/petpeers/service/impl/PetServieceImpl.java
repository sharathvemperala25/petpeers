package com.example.petpeers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petpeers.entity.Pet;
import com.example.petpeers.repository.PetRepository;
import com.example.petpeers.service.PetService;

@Service
public class PetServieceImpl implements PetService{
	
	@Autowired
	PetRepository petRepository;

	@Override
	public boolean savePet(Pet pet) {
		if(pet.getAge()<0 && pet.getAge()>99) {
			return false;
		}
		
		Pet savedPet = petRepository.save(pet);
		
		return true;
	}

	@Override
	public List<Pet> getAllPets() {
		// TODO Auto-generated method stub
		return petRepository.findAll();
	}

}
