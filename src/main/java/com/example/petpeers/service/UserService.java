package com.example.petpeers.service;

import java.util.List;
import java.util.Optional;

import com.example.petpeers.entity.Pet;
import com.example.petpeers.entity.User;

public interface UserService {
	
	boolean addUser(User user);
	
	Long authenticate(String userName,String password);
	
	Optional<User> findByUserName(String UserName);
	
	

	Pet buyPet(Long petId, User user);
	
	List<Pet> getMyPets(User user);

}
