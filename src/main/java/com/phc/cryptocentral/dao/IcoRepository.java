package com.phc.cryptocentral.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.security.access.prepost.PreAuthorize;

import com.phc.cryptocentral.entity.Ico;

public interface IcoRepository extends PagingAndSortingRepository<Ico, Integer> {

	@Query(value = "SELECT * FROM ico WHERE accepted = 1", countQuery = "SELECT * FROM ico WHERE accepted = 1", nativeQuery = true)
	public Page<Ico> findAccepted(Pageable p);
	
	@Query(value = "SELECT * FROM ico WHERE user = ?1", 
			nativeQuery = true)
	public Page<Ico> findByUser(String theUser, Pageable p);
	
//	@SuppressWarnings("unchecked")
//	@Override
//	@PreAuthorize("hasAuthority('create:icos')")
//	Ico save(Ico theIco);
}
