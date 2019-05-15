package com.example.petpeers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.petpeers.controller.UserController;
import com.example.petpeers.entity.Pet;
import com.example.petpeers.entity.User;
import com.example.petpeers.repository.UserRepository;
import com.example.petpeers.service.UserService;
import com.example.petpeers.service.impl.UserServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PetpeersApplicationTests {
	
	@Test
	public void contextload() {
		
	}

}
