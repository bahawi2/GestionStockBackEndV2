package com.bahawi.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bahawi.entities.Produit;
import com.bahawi.entities.Role;
import com.bahawi.entities.User;
import com.bahawi.repositories.RoleRepository;
import com.bahawi.services.IUserService;

@RestController
@RequestMapping("/usercrud")
public class CrudUser {
	@Autowired
	private IUserService userService;
	
	@GetMapping
	public List<User> getAll(){
	return userService.getusers();
	}
	
	@PostMapping
	public void add(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping
	void updateProduit(@RequestBody User u)
	{
		
		userService.updateUser(u);
	}
	@DeleteMapping("/{id}")
	void deleteProduit(@PathVariable  Long id) {
		userService.deleteUser(id);
	}

}
