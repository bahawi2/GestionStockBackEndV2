package com.bahawi.services;

import java.util.List;

import com.bahawi.entities.Produit;

public interface IProuduitService {
	
	List<Produit> getproduits();
	void addProduit(Produit p);
	void updateProduit(Produit p);
	void deleteProduit(Long id);
}
