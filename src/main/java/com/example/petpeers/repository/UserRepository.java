package com.example.petpeers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.petpeers.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select count(u) from User u where u.userName=?1" )
	Long getUserByUserName(String userName);
	
	@Query("select count(u) from User u where u.userName= ?1 AND u.password=?2")	
	Long authenticate(String userName,String password);
	
	User findByUserName(String userName);
}
