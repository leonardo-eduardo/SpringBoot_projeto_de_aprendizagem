package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	/* BUSCA TODOS OS USUÁRIOS */
	public List<User> findAll(){
		return repository.findAll();
	}
	
	/* BUSCA POR ID */
	public User findyBuId(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	/* INSERÇÃO DE USUÁRIO */
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	/* DELEÇÃO DE USUÁRIO */
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	/* ATUALIZAÇÃO DE USUÁRIO */
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
