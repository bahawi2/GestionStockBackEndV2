package com.bahawi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.bahawi.entities.Produit;
@Repository
//@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
