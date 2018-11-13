package com.bahawi.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bahawi.entities.Produit;
import com.bahawi.entities.User;
import com.bahawi.repositories.ProduitRepository;
import com.bahawi.repositories.UserRepository;
import com.bahawi.services.IProuduitService;
import com.bahawi.services.IUserService;

@Service
@Primary
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userrespo;

	

	@Override
	public List<User> getusers() {
		// TODO Auto-generated method stub
		return userrespo.findAll();
	}

	@Override
	public void addUser(User p) {
		userrespo.save(p);
		
	}

	@Override
	public void updateUser(User p) {
		// TODO Auto-generated method stub
		userrespo.delete(p);
		userrespo.save(p);
		
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		User u=new User();
		u.setID(id);
		userrespo.delete(u);
		
		
	}



}
