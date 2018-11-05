package com.bahawi.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bahawi.entities.Produit;
import com.bahawi.services.IProuduitService;

@Service
public class IProduitImpl implements IProuduitService{
	
	private List<Produit> produits;
	public IProduitImpl() {
		produits=new ArrayList<Produit>();
		produits.add(new Produit("Livre",50,20));
		produits.add(new Produit("Cahier",70,120.5f));
		produits.add(new Produit("Stylo",54,30.76f));
	}

	@Override
	public List<Produit> getproduits() {
		// TODO Auto-generated method stub
		return produits;
	}

	@Override
	public void addProduit(Produit p) {
		// TODO Auto-generated method stub
		produits.add(p);
		
	}

	@Override
	public void updateProduit(Produit p) {
		// TODO Auto-generated method stub
		produits.remove(p);
		produits.add(p);
		
	}



	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		Produit p=new Produit();
		p.setId(id);
		produits.remove(p);
		
	}

}
