package com.bahawi.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bahawi.entities.Produit;
import com.bahawi.services.IProuduitService;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin
public class ProduitController {
	@Autowired
	private IProuduitService produitservice;
	
	@GetMapping
	public List<Produit> getproduits(){
		return produitservice.getproduits();
	}
	@PostMapping
	void addProduit(@RequestBody Produit p) {
		produitservice.addProduit(p);
	}
	@PutMapping
	void updateProduit(@RequestBody Produit p)
	{
		System.out.println("prixxx"+p.getPrix());
		produitservice.updateProduit(p);
	}
	@DeleteMapping("/{id}")
	void deleteProduit(@PathVariable  Long id) {
		produitservice.deleteProduit(id);
	}
}
