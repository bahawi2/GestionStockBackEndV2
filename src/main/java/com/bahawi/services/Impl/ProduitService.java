package com.bahawi.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bahawi.entities.Produit;
import com.bahawi.repositories.ProduitRepository;
import com.bahawi.services.IProuduitService;

@Service
@Primary
public class ProduitService implements IProuduitService{
	
	@Autowired
	private ProduitRepository produitrepo;

	@Override
	public List<Produit> getproduits() {

		return produitrepo.findAll();
	}

	@Override
	public void addProduit(Produit p) {

		produitrepo.save(p);
		
	}

	@Override
	public void updateProduit(Produit p) {
		// TODO Auto-generated method stub
		produitrepo.delete(p);
		produitrepo.save(p);
		System.out.println("priiiix"+ p.getPrix());
		
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		produitrepo.delete(produitrepo.getOne(id));
		
	}



}
