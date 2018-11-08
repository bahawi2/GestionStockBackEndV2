package com.bahawi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bahawi.entities.Produit;
import com.bahawi.entities.Role;
import com.bahawi.entities.User;
import com.bahawi.repositories.ProduitRepository;
import com.bahawi.repositories.RoleRepository;
import com.bahawi.repositories.UserRepository;

@SpringBootApplication
public class GestionStockBackEndV2Application implements CommandLineRunner {
	
	@Autowired
	private ProduitRepository produitrepo;
	@Autowired
	private RoleRepository rolerepository;
	@Autowired
	private UserRepository userrespository;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionStockBackEndV2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
/*		produitrepo.save(new Produit("Livre",50,20));
		produitrepo.save(new Produit("Cahier",70,120.5f));
		produitrepo.save(new Produit("Stylo",54,30.76f));
		
		
		Role role2=new Role("ADMIN");
		Role role1=new Role("NORMAL");
		rolerepository.save(role1);
		rolerepository.save(role2);
		User user1=new User("admin", "admin", true);
		
		
		List<Role> roles = new ArrayList<Role>();
		user1.setRoles(Arrays.asList(role1));
		userrespository.save(user1);
		
		User user2=new User("root", "root", true);
		user2.setRoles(Arrays.asList(role1,role2));
		userrespository.save(user2);
		*/
		
		
	}
}
