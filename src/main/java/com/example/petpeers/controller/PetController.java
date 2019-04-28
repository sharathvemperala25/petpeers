package com.example.petpeers.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petpeers.entity.Pet;
import com.example.petpeers.entity.User;
import com.example.petpeers.repository.PetRepository;
import com.example.petpeers.repository.UserRepository;
import com.example.petpeers.service.PetService;
import com.example.petpeers.service.UserService;

@RestController
public class PetController {
	
	@Autowired
	PetService petService;
	
	@Autowired
	UserService userSerrvice;

	@PostMapping("/pets/addPet")
	public ResponseEntity addPet(@RequestBody Pet pet) {
		boolean flag = petService.savePet(pet);
		if(!flag) {
			return new ResponseEntity("age should be between 0 and 99",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity(pet,HttpStatus.CREATED);
	}
	
	@GetMapping("/pets")
	public List<Pet> petHome() {
		return petService.getAllPets();
	}
	
	@PutMapping("/pets/buyPet/{petId}")
	public ResponseEntity buyPet(@PathVariable Long petId,@RequestParam String userName,@RequestParam String password) {
		
		Long flag = userSerrvice.authenticate(userName, password);
		
		if(flag!=1) {
			return new ResponseEntity("you are not authorized user",HttpStatus.BAD_REQUEST);
		}
		
		User user = userSerrvice.findByUserName(userName);
		
		Pet pet = userSerrvice.buyPet(petId, user);
		
		return new ResponseEntity(pet.getOwner().getUserName()+" have purchased the pet with name"+pet.getName()+" successfully",HttpStatus.OK);
		
	}
	
	
	@GetMapping("/pets/myPets")
	public ResponseEntity myPets(@RequestParam String userName,@RequestParam String password) {
        Long flag = userSerrvice.authenticate(userName, password);
		
		if(flag!=1) {
			return new ResponseEntity("you are not authorized user",HttpStatus.BAD_REQUEST);
		}
		
		User user = userSerrvice.findByUserName(userName);
		List<Pet> pets = userSerrvice.getMyPets(user);
		return new ResponseEntity(pets,HttpStatus.OK);
	}
	
	
	
}
