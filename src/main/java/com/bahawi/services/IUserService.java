package com.bahawi.services;

import java.util.List;

import com.bahawi.entities.Produit;
import com.bahawi.entities.User;

public interface IUserService {
	
	
	List<User> getusers();
	void addUser(User p);
	void updateUser(User p);
	void deleteUser(Long id);
}
