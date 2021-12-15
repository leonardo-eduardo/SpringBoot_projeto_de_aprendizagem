package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.educandoweb.curso.entities.Category;
import com.educandoweb.curso.entities.Order;
import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.entities.enums.OrderStatus;
import com.educandoweb.curso.repositories.CategoryRepository;
import com.educandoweb.curso.repositories.OrderRepository;
import com.educandoweb.curso.repositories.ProductRepository;
import com.educandoweb.curso.repositories.UserRepository;

@Configuration
@Profile("test")
@Repository
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProductRepository ProductRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		User u1 = new User(null, "Leonardo Eduardo", "leonardo.eduardo@mail.com", "21984046474", "123456");
		User u2 = new User(null, "Rafael Eduardo", "Rafel.eduardo@mail.com", "21984046475", "12346");
		User u3 = new User(null, "Bento Eduardo", "bento.eduardo@gmail.com", "21984046476", "1235");

		Order o1 = new Order(null, Instant.parse("2021-12-06T15:38:20Z"), OrderStatus.SHIPPED, u1);
		Order o2 = new Order(null, Instant.parse("2021-11-05T10:37:55Z"), OrderStatus.CANCELED, u3);
		Order o3 = new Order(null, Instant.parse("2021-10-06T11:28:15Z"), OrderStatus.CANCELED, u2);
		Order o4 = new Order(null, Instant.parse("2021-12-01T09:35:20Z"), OrderStatus.DELIVERED, u3);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		ProductRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}

}
