package com.example.petpeers.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;

import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.petpeers.entity.Pet;
import com.example.petpeers.entity.User;
import com.example.petpeers.repository.PetRepository;
import com.example.petpeers.repository.UserRepository;
import com.example.petpeers.service.impl.PetServieceImpl;
import com.example.petpeers.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@InjectMocks
	UserService userService = new UserServiceImpl();	
	
	@InjectMocks
	PetService petService = new PetServieceImpl();
	
	@Mock
	PetRepository petRepository;
	
	
	@Mock
	UserRepository userRepository;
	
	@BeforeClass
	public static void setUp() {

		
	}

	@Test
	public void testaddUserForExistingUser() {
		User user = new User();
		user.setId(1L);
		user.setUserName("sharath");
		user.setPassword("1234");
		user.setConfirmPassword("1234");	
		boolean flag = userService.addUser(user);
		System.out.println(flag);
		assertThat(flag==false);
	}
	
	
	@Test
	public void testaddUserForNewUser() {
		User user = new User();
		user.setId(1L);
		user.setUserName("sharath");
		user.setPassword("1234");
		user.setConfirmPassword("1234");	
		Mockito.when(userRepository.findByUserName(user.getUserName())).thenReturn(Optional.ofNullable(null));	
		boolean flag = userService.addUser(user);
		assertThat(flag == true);
	
	}
	
	@Test
	public void testauthenticateExistingUser() {
		
		User user = new User();
		user.setId(1L);
		user.setUserName("sharath");
		user.setPassword("1234");
		user.setConfirmPassword("1234");
		Mockito.when(userRepository.authenticate(user.getUserName(), user.getPassword())).thenReturn(1L);
		Long flag = userService.authenticate(user.getUserName(), user.getPassword());
		assertThat(flag == 1L);
		
	}
	
	
//	@Test
//	public void testbuymyPet() {
//		Pet pet = new Pet();
//		pet.setId(1L);
//		pet.setName("cow");
//		pet.setAge(14);
//		pet.setPlace("hyd");
//		User user = new User();
//		user.setId(1L);
//		user.setUserName("sharath");
//		user.setPassword("1234");
//		//user.setConfirmPassword("1234");
//
//		Optional<Pet> optionalPet = Optional.of(pet);
//		Mockito.when(petRepository.findById(1L)).thenReturn(optionalPet);
//		Mockito.when(petRepository.save(any(Pet.class))).thenReturn();
//		Pet savedPet = userService.buyPet(1L, user);
//		
//		assertThat(savedPet.getOwner().getId()==1L);
//		
//		
//	}
	

}

