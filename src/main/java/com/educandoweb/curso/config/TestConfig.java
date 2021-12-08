package com.educandoweb.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.UserRepository;

@Configuration
@Profile("test")
@Repository
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(1, "Rafael Eduardo", "21984046475", "1234");
		User u2 = new User(2, "Bento Eduardo", "21984046476", "123");
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
}
