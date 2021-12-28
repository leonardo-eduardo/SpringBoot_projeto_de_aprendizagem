package com.educandoweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.curso.entities.User;
/* Responsável por fazer as operações com entidade User reutilizando o JpaRepository*/
@Repository
/* Não é necessário esta anotação pois, sendo UserRepository extensão do JpaRepository que já está registrado no Spring */
public interface UserRepository extends JpaRepository<User, Long> {

}
