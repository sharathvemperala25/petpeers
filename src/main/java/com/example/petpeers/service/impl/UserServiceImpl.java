package com.example.petpeers.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.stereotype.Service;

import com.example.petpeers.entity.Pet;
import com.example.petpeers.entity.User;
import com.example.petpeers.repository.PetRepository;
import com.example.petpeers.repository.UserRepository;
import com.example.petpeers.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PetRepository petRepository;

	@Override
	public boolean addUser(User user) {
		boolean existUser = false;
		
		Long count = userRepository.getUserByUserName(user.getUserName());
		
		
		if (count == 0) {
			userRepository.save(user);
			existUser = true;
		}
		
		return existUser;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long authenticate(String userName, String password) {
		
		
		
		return userRepository.authenticate(userName, password);
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
		}

	@Override
	public Pet buyPet(Long petId, User user) {
		
	  Pet pet = petRepository.findById(petId).get();
	  pet.setOwner(user);
	  
		return petRepository.save(pet); 
	}

	@Override
	public List<Pet> getMyPets(User user) {
		
		return user.getPets();
	}
	
	
	
	
	
	
	

}
