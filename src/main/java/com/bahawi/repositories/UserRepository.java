package com.bahawi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bahawi.entities.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	User findByUsername(String username);
	User findByPassword(String password);

}
