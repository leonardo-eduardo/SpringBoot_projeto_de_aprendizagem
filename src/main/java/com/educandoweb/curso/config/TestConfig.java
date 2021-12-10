package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.OrderRepository;
import com.educandoweb.curso.repositories.UserRepository;

@Configuration
@Profile("test")
@Repository
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(1, "Leonardo Eduardo", "leonardo.eduardo@mail.com", "21984046474", "123456");
		User u2 = new User(2, "Rafael Eduardo", "Rafel.eduardo@mail.com", "21984046475", "12346");
		User u3 = new User(3, "Bento Eduardo", "bento.eduardo@gmail.com", "21984046476", "1235");
		
		Order o1 = new Order(1, Instant.parse("2021-12-06T15:38:20Z"), u1);
		Order o2 = new Order(2, Instant.parse("2021-11-05T10:37:55Z"), u3);
		Order o3 = new Order(3, Instant.parse("2021-10-06T11:28:15Z"), u2);
		Order o4 = new Order(4, Instant.parse("2021-12-01T09:35:20Z"), u3);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
	}
	
}
