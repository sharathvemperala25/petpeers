package com.example.petpeers.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petpeers.entity.Pet;
import com.example.petpeers.entity.User;
import com.example.petpeers.service.PetService;
import com.example.petpeers.service.UserService;

@RestController
public final class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PetService petService;

	@PostMapping("/users/addUser")
	public ResponseEntity addUser(@RequestBody User user) {
		
		System.out.println("Hi1");
		String password = user.getPassword();
		System.out.println("Hi2");

		String confirmpassword = user.getConfirmPassword();
		System.out.println("Hi3");
		System.out.println(password.equals(confirmpassword));
		if(!password.equals(confirmpassword)) {
			return new ResponseEntity("Confirm password did not match",HttpStatus.BAD_REQUEST);
			
		}
		
		
		boolean existUser = userService.addUser(user);
		if(existUser){
		return new ResponseEntity(user,HttpStatus.CREATED);
		}
		return new ResponseEntity("user with name"+user.getUserName()+"already exists",HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity authenticate(@RequestParam String userName,@RequestParam String password) {
		Long flag = userService.authenticate(userName, password);
		System.out.println(flag);
		if(flag != 1) {
			return new ResponseEntity("not an authorise User",HttpStatus.NOT_FOUND);
		}
		List<Pet> pets = petService.getAllPets();
		return new ResponseEntity(pets,HttpStatus.OK);
	}

}
